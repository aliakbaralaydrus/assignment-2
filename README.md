# GPA Calculator Application

## Overview

The GPA Calculator Application is designed to help students calculate their Grade Point Average (GPA) based on their course grades and credits. The application allows users to input course details, such as course name, grade, and credits, and then calculates the GPA accordingly. Users can save and reload their student data to/from a file for future reference.

## Features

- **Calculate GPA:** Input course grades and credits to calculate the GPA for a student.
- **Save/Load Data:** Save and reload student data to/from a file for future use.
- **Add Multiple Courses:** Add multiple courses to a student at once to save time.
- **Update Conversion Factor:** Customize the GPA calculation by updating the conversion factor.

## User Stories

### Saving Application State:
- As a user, I want to be able to save the entire state of the application to a file so that I can preserve my progress and data.
  - **Scenario:**
    - Given that I am using the application,
    - When I navigate to the "File" menu and select "Save",
    - Then the application should prompt me to choose a location to save the file,
    - And upon confirmation, the application should save all relevant data, including user preferences, inputted information, and current state, to the specified file.

### Reloading Application State:
- As a user, I want to be able to reload the previously saved state of the application from a file so that I can resume exactly where I left off at a later time.
  - **Scenario:**
    - Given that I have previously saved the state of the application,
    - When I start the application again or choose the "Load" option from the "File" menu,
    - Then the application should prompt me to select the saved file,
    - And upon selection, the application should load all saved data, restoring the previous state, including user preferences, inputted information, and current progress.

## Realizations

1. **Adding Multiple Courses to a Student:**
   - As a user, I want to be able to add multiple courses to a student at once to save time and effort.
     - **Realization:**
       - Implement a feature in the UI where the user can input details for multiple courses for a student in a single step. This could involve displaying a form where the user can enter the course name, grade, and credits for each course, and then clicking a "Submit" button to add all the courses to the student at once.

2. **Calculating GPA for a Student:**
   - As a user, I want the application to calculate the GPA for a student based on their course grades and credits.
     - **Realization:**
       - Implement a method in the `Student` class to calculate the GPA by iterating over the courses, multiplying each course grade by its corresponding credits, summing up the total grade points, and then dividing by the total credits.

3. **Saving Student Data to a File:**
   - As a user, I want to be able to save the student data to a file so that I can preserve it for future use.
     - **Realization:**
       - Implement the `saveStudent` method in the `FileHandler` class to serialize the student object and save it to a file using Java's Object Serialization.

4. **Reloading Student Data from a File:**
   - As a user, I want to be able to reload the previously saved student data from a file so that I can resume working with it.
     - **Realization:**
       - Implement the `loadStudent` method in the `FileHandler` class to deserialize the student object from a file and load it back into the application, allowing the user to continue working with the previously saved data.
