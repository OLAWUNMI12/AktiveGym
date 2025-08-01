package com.aktive.gym.service;


import com.aktive.gym.dto.request.GetUsersRequest;
import com.aktive.gym.dto.request.UserEmailRequest;
import com.aktive.gym.dto.response.TrainerResponse;
import com.aktive.gym.dto.response.UserResponse;
import com.aktive.gym.model.Notification;
import com.aktive.gym.model.User;
import com.aktive.gym.repo.NotificationRepository;
import com.aktive.gym.repo.UserRepository;
import com.aktive.gym.service.pagination.CustomPage;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  EmailService emailService;

    @Autowired
    private  NotificationRepository notificationRepository;

    @Value("${login.url}")
    private String loginUrl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepository.findByEmail(username);
        return userDetail
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }


    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }


    public CustomPage<UserResponse> getUsers(GetUsersRequest getUsersRequest){
        Pageable pageable = PageRequest.of(getUsersRequest.getPageNumber() - 1, getUsersRequest.getPageSize());
        Page<User> users  = userRepository.searchUsers(StringUtils.hasText(getUsersRequest.getSearchQuery()) ? getUsersRequest.getSearchQuery() : "", pageable);
        return getUserResponseCustomPage(users.getContent(), users, getUsersRequest);
    }


    public void sendUserCustomEmail(UserEmailRequest userEmailRequest){
        int pageNumber = 0;
        Page<User> page;

        do {
            Pageable pageable = PageRequest.of(pageNumber, 20);
            page = userRepository.findAll(pageable);

            for (User user : page.getContent()) {
                sendUserEmail(user, userEmailRequest.getMessage(), userEmailRequest.getSubject());
            }

            pageNumber++;
        } while (!page.isLast());

        Notification notification = Notification.builder()
                .message(userEmailRequest.getMessage())
                .subject(userEmailRequest.getSubject())
                .notificationType(userEmailRequest.getNotificationType())
                .createdAt(new Date())
                .build();
        notificationRepository.save(notification);
    }



    private static CustomPage<UserResponse> getUserResponseCustomPage(List<User> users, Page usersPage, GetUsersRequest getUsersRequest) {
        List<UserResponse> usersResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = new UserResponse();
            userResponse.setName(user.getFullName());
            userResponse.setEmail(user.getEmail());
            userResponse.setDateJoined(user.getCreatedAt());
            userResponse.setGender(user.getGender());
            userResponse.setUserRole(user.getUserRole());
            userResponse.setAge(user.getAge());
            userResponse.setStatus(user.getStatus());
            if(Objects.nonNull(user.getTrainer())) {
                TrainerResponse trainerResponse = new TrainerResponse();
                trainerResponse.setId(user.getTrainer().getId());
                trainerResponse.setFullName(user.getTrainer().getFullName());
                trainerResponse.setRole(user.getTrainer().getRole());
                userResponse.setTrainer(trainerResponse);
            }
            usersResponses.add(userResponse);
        }

        CustomPage<UserResponse> customPage = new CustomPage<>();
        customPage.setContent(usersResponses);
        customPage.setPageNumber(usersPage.getNumber() + 1);
        customPage.setPageSize(usersPage.getSize());
        customPage.setTotalElements(usersPage.getTotalElements());
        customPage.setTotalPages(usersPage.getTotalPages());
        customPage.setLast(usersPage.isLast());
        customPage.setFirst(usersPage.isFirst());
        customPage.setEmpty(usersPage.isEmpty());
        return customPage;

        }




    private void sendUserEmail(User user, String message, String subject) {
        Map<String, Object> params = new HashMap<>();
        params.put("fullName", user.getFullName());
        params.put("message", message);
        params.put("loginUrl", loginUrl);

        try {
            emailService.sendMail(user.getEmail(), subject, params, "customTemplate");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }




}
