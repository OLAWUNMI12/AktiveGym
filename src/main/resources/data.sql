--INSERT INTO trainer (
--    id, full_name, role, years_of_experience, description,
--    speciality, available_period, certification, rating
--) VALUES
--
--(11, 'Aaliyah Mensah', 'Strength & Conditioning Coach | Athletic Development Expert', 6,
-- 'Aaliyah trains athletes to peak performance levels with sport-specific strength, agility, and injury prevention techniques.',
-- '- Speed & Agility Training - Plyometrics & Conditioning - Athlete Rehab Programs - Explosive Power Development ',
-- 'Mon-Sat | 6am-2pm', 'CSCS, NASM-PES', 4.8),
--
--(12, 'Carlos Mendes', 'Boxing & Combat Trainer | Amateur Fight Coach', 8,
-- 'Carlos develops fighters from beginners to ring-ready warriors with technical boxing, footwork drills, and cardio conditioning.',
-- '- Technical Boxing - Footwork & Defense Drills - Pad Work & Sparring Prep - Conditioning for Fighters ',
-- 'Tue-Sun | 11am-8pm', 'USA Boxing Level 2, ISSA', 4.6),
--
--(13, 'Emily Zhang', 'Pilates Instructor | Core & Posture Specialist', 4,
-- 'Emily focuses on controlled movement and postural alignment through contemporary and reformer-based Pilates techniques.',
-- '- Mat & Reformer Pilates - Posture & Core Control - Low Impact Strength - Flexibility & Stability Training ',
-- 'Mon-Fri | 8am-5pm', 'Balanced Body Certified, BASI', 4.4),
--
--(14, 'Jacob Okoro', 'Calisthenics & Mobility Coach | Bodyweight Training Expert', 5,
-- 'Jacob helps clients master bodyweight strength through progressive calisthenics and functional movement patterns.',
-- '- Calisthenics Progressions - Handstand & Planche Skills - Joint Mobility & Range - Functional Movement Training ',
-- 'Wed-Sun | 10am-7pm', 'GMB Trainer, NASM-CPT', 4.7),
--
--(15, 'Fatima Al-Hassan', 'Weight Loss & Lifestyle Coach | Sustainable Fitness Mentor', 7,
-- 'Fatima supports long-term weight loss goals with a focus on mindset, habit-building, and flexible fitness routines.',
-- '- Weight Loss Coaching - Lifestyle & Habit Development - Low-Impact Strength - Behavioral Nutrition Support ',
-- 'Mon-Fri | 9am-4pm', 'Precision Nutrition L1, CPT (ACE)', 4.5),
--
--(16, 'Noah Jensen', 'Endurance Coach | Marathon & Triathlon Specialist', 10,
-- 'Noah guides endurance athletes through evidence-based programming for long-distance events and overall aerobic performance.',
-- '- Marathon & Triathlon Training - VO2 Max & Lactate Threshold - Recovery & Overtraining Prevention - Nutrition for Endurance ',
-- 'Mon-Sat | 6am-1pm', 'USAT L1, RRCA Certified Coach', 4.9),
--
--(17, 'Isabella Moretti', 'Dance Fitness Coach | Zumba & Cardio-Dance Expert', 6,
-- 'Isabella energizes clients through rhythm-based fitness classes that promote cardio, coordination, and fun!',
-- '- Zumba & Dance Cardio - Rhythm & Coordination - Fat Burn through Movement - Group Energy Coaching ',
-- 'Mon-Sun | 10am-8pm', 'Zumba Certified, AFAA Group Fitness', 4.3),
--
--(18, 'David Okafor', 'Kettlebell & Functional Strength Coach | Flow Specialist', 5,
-- 'David combines kettlebell flow, mobility, and unconventional tools to build total-body strength and coordination.',
-- '- Kettlebell Sport & Flow - Functional Strength Circuits - Grip & Core Development - Breath-led Training ',
-- 'Mon-Fri | 7am-6pm', 'StrongFirst KBI, ONNIT Academy', 4.6),
--
--(19, 'Leila Saeed', 'Prenatal & Postnatal Fitness Coach | Women’s Wellness Specialist', 4,
-- 'Leila helps mothers maintain strength and mobility during and after pregnancy with gentle, targeted fitness routines.',
-- '- Safe Prenatal Movement - Core & Pelvic Floor Rehab - Postpartum Strength - Mindful Recovery Support ',
-- 'Mon-Sat | 9am-3pm', 'ACE Certified, Pre/Postnatal FitPro', 4.5),
--
-- (20, 'Max Thomas', 'Bodybuilding Coach | 10+ Years Experience', 10,
-- 'Max is a certified strength and hypertrophy coach with a passion for building strong, aesthetic physiques through proper form, discipline, and science-backed programs.',
--  '- Muscle Growth (Hypertrophy Training) - Contest Prep & Aesthetic Shaping, - Strength & Resistance Programming - Recovery & Supplement Coaching ',
--   'Mon-Sat | 7am-8pm', 'NASM, IFBB Pro Level Trainer', 4.9),
--
--(21, 'Marcus Lee', 'Rehabilitation & Movement Coach | Injury Recovery Specialist', 11,
-- 'Marcus specializes in post-injury recovery and corrective exercise, helping clients restore movement, reduce pain, and rebuild strength safely.',
-- '- Post-Injury Rehabilitation - Corrective Exercise Programming - Pain-Free Strength Training - Movement Pattern Analysis ',
-- 'Tue-Sat | 8am-4pm', 'NASM-CES, FMS Level 2', 4.8),
--
-- (22, 'Liam Chen', 'Powerlifting Coach | State Champion Lifter', 4,
-- ' Liam brings raw strength and expert guidance to athletes looking to maximize their squat, bench, and deadlift performance. ',
--  '- Powerlifting (Squat, Bench, Deadlift) - Form Correction & Plateau Breaking - Strength Periodization - Competition Prep ',
--   'Tue-Sat | 8am-5pm', 'USAPL Certified, NSCA-CSCS', 4.9),
--
-- (23, 'Jade Kim', 'Functional Fitness Trainer | Movement Specialist', 7,
--   ' Jade blends athletic training with mobility and injury prevention to create smart, sustainable ',
--    '- Mobility & Flexibility Training - Injury Prevention - Functional Strength Programs - Athletic Movement Coaching',
--     'Mon-Sat | 10am-7pm', 'FRCms, NASM-CPT', 4.6),
--
-- (24, 'Ethan Brooks', 'CrossFit & Conditioning Coach | Ex-Marine Trainer', 9,
--   ' Ethan brings discipline and intensity to his workouts, helping clients push past their limits through functional and high-intensity training.',
--    '- CrossFit WODs - HIIT & Endurance Conditioning - Military-Style Fitness - Mental Toughness Coaching ',
--     'Mon-Fri | 6am-6pm', 'CrossFit L2, ISSA', 4.5),
--
-- (25, 'Nina Patel', 'Yoga & Recovery Coach | Holistic Wellness Guide', 3,
--   ' Nina helps clients reconnect with their bodies through yoga, breathwork, and mindful recovery practices tailored for all fitness levels.',
--    '- Vinyasa & Hatha Yoga - Deep Stretch & Mobility - Breathwork & Meditation - Stress & Recovery Coaching ',
--     'Mon-Sun | 8am-8pm', 'RYT-500, Breathwork Facilitator', 4.7);
--

   --------------------------------------------------------------------------------  --------------------------------------------------------------------------------



    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES
      (1, 'Tofu & Veggie Stir-Fry (1 cup)', 'LOOSE_WEIGHT', 'VEGAN', 250, 20, 15, 12),
      (2, 'Lentil Soup with Spinach (1 bowl)', 'LOOSE_WEIGHT', 'VEGAN', 190, 25, 12, 4),
      (3, 'Chickpea Salad with Olive Oil & Lemon (1 bowl)', 'LOOSE_WEIGHT', 'VEGAN', 300, 30, 14, 14),
      (4, 'Zucchini Noodles with Marinara & Mushrooms', 'LOOSE_WEIGHT', 'VEGAN', 220, 28, 8, 9),
      (5, 'Oats with Chia Seeds, Berries & Almond Milk', 'LOOSE_WEIGHT', 'VEGAN', 280, 38, 9, 10),
      (6, 'Grilled Tempeh with Steamed Broccoli', 'LOOSE_WEIGHT', 'VEGAN', 260, 15, 18, 14),
      (7, 'Cauliflower Rice Bowl with Avocado', 'LOOSE_WEIGHT', 'VEGAN', 230, 20, 6, 14),
      (8, 'Smoothie (Spinach, Banana, Flaxseed, Almond Butter)', 'LOOSE_WEIGHT', 'VEGAN', 300, 35, 10, 12),
      (9, 'Stuffed Bell Peppers with Quinoa & Black Beans', 'LOOSE_WEIGHT', 'VEGAN', 270, 34, 13, 8),
      (10, 'Vegan Buddha Bowl (Brown Rice, Tofu, Kale, Tahini)', 'LOOSE_WEIGHT', 'VEGAN', 320, 36, 16, 14),
      (11, 'Grilled Chicken Breast with Steamed Green Beans', 'LOOSE_WEIGHT', 'NON_VEGAN', 260, 8, 30, 10),
      (12, 'Tuna Salad with Olive Oil Dressing', 'LOOSE_WEIGHT', 'NON_VEGAN', 280, 5, 28, 16),
      (13, 'Scrambled Eggs with Spinach & Tomatoes', 'LOOSE_WEIGHT', 'NON_VEGAN', 240, 6, 18, 16),
      (14, 'Baked Salmon with Asparagus', 'LOOSE_WEIGHT', 'NON_VEGAN', 320, 4, 25, 20),
      (15, 'Turkey Lettuce Wraps with Avocado', 'LOOSE_WEIGHT', 'NON_VEGAN', 290, 10, 22, 18),
      (16, 'Grilled Shrimp with Quinoa & Zucchini', 'LOOSE_WEIGHT', 'NON_VEGAN', 300, 25, 24, 10),
      (17, 'Egg White Omelet with Veggies', 'LOOSE_WEIGHT', 'NON_VEGAN', 210, 5, 20, 8),
      (18, 'Greek Yogurt with Blueberries & Chia', 'LOOSE_WEIGHT', 'NON_VEGAN', 250, 20, 20, 9),
      (19, 'Boiled Eggs with Cucumber & Carrot Sticks', 'LOOSE_WEIGHT', 'NON_VEGAN', 230, 7, 14, 15),
      (20, 'Grilled Tilapia with Cauliflower Mash', 'LOOSE_WEIGHT', 'NON_VEGAN', 280, 10, 26, 14);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES
    (21, 'Grilled Chicken with Sweet Potato & Broccoli', 'MAINTAIN_WEIGHT', 'NON_VEGAN', 450, 35, 35, 18),
    (22, 'Baked Salmon with Brown Rice & Spinach', 'MAINTAIN_WEIGHT', 'NON_VEGAN', 480, 40, 32, 22),
    (23, 'Omelet with 2 Whole Eggs, 2 Egg Whites, & Veggies', 'MAINTAIN_WEIGHT', 'NON_VEGAN', 400, 10, 28, 25),
    (24, 'Ground Turkey Bowl with Quinoa & Bell Peppers', 'MAINTAIN_WEIGHT', 'NON_VEGAN', 470, 38, 34, 20),
    (25, 'Tuna Sandwich (Whole Wheat Bread, Light Mayo, Lettuce)', 'MAINTAIN_WEIGHT', 'NON_VEGAN', 420, 35, 30, 15),
    (26, 'Greek Yogurt Parfait with Granola & Berries', 'MAINTAIN_WEIGHT', 'NON_VEGAN', 400, 38, 22, 14),
    (27, 'Grilled Shrimp & Avocado Tacos (Corn Tortillas)', 'MAINTAIN_WEIGHT', 'NON_VEGAN', 460, 30, 28, 22),
    (28, 'Roasted Chicken Thigh with Couscous & Green Beans', 'MAINTAIN_WEIGHT', 'NON_VEGAN', 470, 40, 30, 20),
    (29, 'Hard-Boiled Eggs, Whole Grain Toast & Peanut Butter', 'MAINTAIN_WEIGHT', 'NON_VEGAN', 440, 30, 22, 24),
    (30, 'Tilapia with Baked Potato & Mixed Veggies', 'MAINTAIN_WEIGHT', 'NON_VEGAN', 460, 42, 30, 18),
    (31, 'Chickpea & Quinoa Power Bowl (with Tahini Dressing)', 'MAINTAIN_WEIGHT', 'VEGAN', 480, 45, 20, 22),
    (32, 'Lentil Stew with Potatoes & Carrots', 'MAINTAIN_WEIGHT', 'VEGAN', 450, 50, 18, 14),
    (33, 'Tofu Stir-Fry with Brown Rice & Broccoli', 'MAINTAIN_WEIGHT', 'VEGAN', 470, 42, 24, 20),
    (34, 'Vegan Pasta with Tomato Sauce, Spinach & Mushrooms', 'MAINTAIN_WEIGHT', 'VEGAN', 460, 55, 16, 14),
    (35, 'Oats with Almond Butter, Banana & Chia Seeds', 'MAINTAIN_WEIGHT', 'VEGAN', 440, 48, 12, 20),
    (36, 'Black Bean & Corn Burrito (Whole Wheat Tortilla)', 'MAINTAIN_WEIGHT', 'VEGAN', 490, 50, 20, 18),
    (37, 'Vegan Curry with Chickpeas & Basmati Rice', 'MAINTAIN_WEIGHT', 'VEGAN', 480, 52, 17, 18),
    (38, 'Tempeh Salad with Olive Oil, Nuts & Mixed Greens', 'MAINTAIN_WEIGHT', 'VEGAN', 450, 25, 22, 26),
    (39, 'Smoothie Bowl (Banana, Berries, Protein Powder, Flax)', 'MAINTAIN_WEIGHT', 'VEGAN', 460, 40, 20, 18),
    (40, 'Stuffed Bell Peppers with Brown Rice & Vegan Cheese', 'MAINTAIN_WEIGHT', 'VEGAN', 470, 50, 16, 20);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (41, 'Tofu & Peanut Butter Stir-Fry with Jasmine Rice', 'GAIN_WEIGHT', 'VEGAN', 650, 55, 28, 32);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (42, 'Vegan Lentil Burger with Avocado & Sweet Potato Fries', 'GAIN_WEIGHT', 'VEGAN', 700, 60, 26, 36);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (43, 'Chickpea Coconut Curry with Brown Rice', 'GAIN_WEIGHT', 'VEGAN', 680, 62, 20, 34);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (44, 'Tempeh Wrap with Hummus, Avocado & Whole Grain Tortilla', 'GAIN_WEIGHT', 'VEGAN', 720, 48, 30, 40);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (45, 'Vegan Pasta with Cashew Alfredo Sauce & Broccoli', 'GAIN_WEIGHT', 'VEGAN', 690, 60, 22, 35);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (46, 'Oatmeal with Peanut Butter, Banana, Maple Syrup & Seeds', 'GAIN_WEIGHT', 'VEGAN', 710, 64, 20, 36);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (47, 'Smoothie (Soy Milk, Peanut Butter, Banana, Oats, Protein Powder)', 'GAIN_WEIGHT', 'VEGAN', 750, 58, 35, 38);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (48, 'Quinoa Bowl with Black Beans, Corn, Avocado & Vegan Cheese', 'GAIN_WEIGHT', 'VEGAN', 680, 54, 25, 34);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (49, 'Stuffed Vegan Burrito (Beans, Rice, Guac, Tofu, Vegan Sour Cream)', 'GAIN_WEIGHT', 'VEGAN', 760, 62, 28, 40);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (50, 'Vegan Shepherd’s Pie with Lentils, Potatoes, & Olive Oil', 'GAIN_WEIGHT', 'VEGAN', 700, 60, 22, 32);

    -- NON_VEGAN GAIN_WEIGHT
    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (51, 'Grilled Chicken Breast with Avocado, Quinoa & Olive Oil', 'GAIN_WEIGHT', 'NON_VEGAN', 720, 50, 48, 32);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (52, 'Beef Stir-Fry with Jasmine Rice & Sesame Oil', 'GAIN_WEIGHT', 'NON_VEGAN', 760, 58, 42, 38);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (53, 'Salmon Fillet with Mashed Potatoes & Buttered Veggies', 'GAIN_WEIGHT', 'NON_VEGAN', 740, 48, 38, 40);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (54, 'Tuna Pasta with Cream Sauce, Peas & Cheese', 'GAIN_WEIGHT', 'NON_VEGAN', 700, 60, 35, 30);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (55, 'Scrambled Eggs with Turkey Bacon, Toast & Avocado', 'GAIN_WEIGHT', 'NON_VEGAN', 680, 40, 32, 36);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (56, 'Greek Yogurt Bowl with Honey, Almonds, Granola & Banana', 'GAIN_WEIGHT', 'NON_VEGAN', 720, 55, 28, 32);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (57, 'Grilled Lamb Chops with Couscous & Roasted Vegetables', 'GAIN_WEIGHT', 'NON_VEGAN', 780, 50, 40, 42);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (58, 'Shrimp Alfredo Pasta with Spinach & Parmesan', 'GAIN_WEIGHT', 'NON_VEGAN', 710, 58, 34, 34);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (59, 'Hard-Boiled Eggs, Peanut Butter Toast & Milk', 'GAIN_WEIGHT', 'NON_VEGAN', 690, 45, 30, 36);

    INSERT INTO dietary_plan (id, description, type, food_type, calories, carbs, protein, fat)
    VALUES (60, 'Chicken Burrito (Brown Rice, Cheese, Guac, Beans, Sour Cream)', 'GAIN_WEIGHT', 'NON_VEGAN', 750, 62, 42, 38);
