/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vmware.bookseat.ui.model

object DataProvider {

    val puppy =
        Puppy(
            id = 1,
            title = "Monty",
            sex = "Male",
            age = 14,
            description = "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        )

    val puppyList = listOf(
        puppy,
        Puppy(
            id = 2,
            title = "Jubilee",
            sex = "Female",
            age = 6,
            description = "Jubilee enjoys thoughtful discussions by the campfire.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
        Puppy(
            id = 3,
            title = "Beezy",
            sex = "Male",
            age = 8,
            description = "Beezy's favorite past-time is helping you choose your brand color.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
        Puppy(
            id = 4,
            title = "Mochi",
            sex = "Male",
            age = 10,
            description = "Mochi is the perfect \"rubbery ducky\" debugging pup, always listening.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
        Puppy(
            id = 5,
            title = "Brewery",
            sex = "Female",
            age = 12,
            description = "Brewery loves fetching you your favorite homebrew.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
        Puppy(
            id = 6,
            title = "Lucy",
            sex = "Female",
            age = 8,
            description = "Picture yourself in a boat on a river, Lucy is a pup with kaleidoscope eyes.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
        Puppy(
            id = 7,
            title = "Astro",
            sex = "Male",
            age = 10,
            description = "Is it a bird? A plane? No, it's Astro blasting off into your heart!",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
        Puppy(
            id = 8,
            title = "Boo",
            sex = "Female",
            age = 9,
            description = "Boo is just a teddy bear in disguise. What he lacks in grace, he makes up in charm.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
        Puppy(
            id = 9,
            title = "Pippa",
            sex = "Male",
            age = 7,
            description = "Pippa likes to look out the window and write pup-poetry.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
        Puppy(
            id = 10,
            title = "Coco",
            sex = "Female",
            age = 10,
            description = "Coco enjoys getting pampered at the local puppy spa.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
        Puppy(
            id = 11,
            title = "Brody",
            sex = "Male",
            age = 13,
            description = "Brody is a good boy, waiting for your next command.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
        Puppy(
            id = 12,
            title = "Stella",
            sex = "Female",
            age = 14,
            description = "Stella! Calm and always up for a challenge, she's the perfect companion.",
            puppyImageId = com.google.android.material.R.drawable.m3_appbar_background,
        ),
    )
}
