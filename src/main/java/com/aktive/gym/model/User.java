package com.aktive.gym.model;


import com.aktive.gym.util.constants.CommonConstants;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Table(name = "users")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, name = "membership_id")
    private String membershipId;

    @Column(nullable = false, name = "full_name")
    private String fullName;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private CommonConstants.Gender gender;

    private Long age;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "membership_plan")
    private CommonConstants.MembershipPlan membershipPlan;

    @Enumerated(EnumType.STRING)
    @Column( name = "user_role")
    private CommonConstants.UserRole userRole = CommonConstants.UserRole.MEMBER;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fitness_and_body_info_id")
    private FitnessAndBodyInfo fitnessAndBodyInfo;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_info_id")
    private PaymentInfo paymentInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column
    private String status = "Active";

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    @PrePersist
    public void prePersist() {
        if (StringUtils.isBlank(status)) {
            status = "Active";
            userRole = CommonConstants.UserRole.MEMBER;
        }
    }
}
