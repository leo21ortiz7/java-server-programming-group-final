# Java Server Programming Group Final
This project was submitted by me and two other classmates as a group final for the Java Server Programming course at Southeast Community College.

The purpose of this assignment was to demonstrate our understanding of database management, user roles and permissions, password encryption, and application security.

## Key Features
1. New users are able to register for an account using a valid email and password.
2. Existing users can log into their account with credentials stored in the database.
3. Passwords are encrypted with SHA-256.
4. Logged in users can edit their own information and see a list of all other users.
5. Users logged in as admins can view all user's information, including their hashed passwords.
6. Users logged in as admins can delete and edit all users to the database.
7. Regular users are prevented from accessing admin-only pages.
8. Input fields are protected against cross-site scripting attacks.
