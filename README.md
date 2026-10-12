# Restaurant Table Reservation System with Java

A comprehensive Java Swing-based desktop application designed for managing restaurant table reservations, customer accounts, and administrative operations.

**GitHub Repository:** [Restaurant-Table-Reservation-System-with-java](https://github.com/LahiruButhsara34/Restaurant-Table-Reservation-System-with-java)

---

## Features & User Flow

* **Welcome Page:** Animated loading screen with a progress bar (0% to 100%) that directs users to the sign-up page.
* **Sign-up & Login Module:** New users can create accounts with username, password, email, and contact info. Existing users or admins can login directly (Admin default credentials: username `admin`, password `123`).
* **Home Page (Reservation Form):** Core page for users to select date, time slots, room categories, and fill out customer details for table booking.
* **Customer Services:** Provides payment guidelines, restaurant contact numbers, email, and bank account details (BOC & Sampath Bank) for booking confirmations.
* **Table Categories & Availability Check:**
  * **First Floor Tables:** Normal (A) & Special (B) tables.
  * **Outdoor Tables:** Normal (C) & Special (D) tables.
  * **VIP Floor Tables:** Normal (E) & Special (F) tables with multiple exclusive facilities.
* **Admin Dashboard:** Automatically calculates registered customers, total tables, and bookings, linking to Table Manager, Booking Manage, and Registration Manage.

---

## Technologies Used & Prerequisites

* **Language:** Java (JDK 8 or higher)
* **IDE:** Apache NetBeans IDE 19
* **Database Management:** XAMPP Control Panel (MySQL / phpMyAdmin)
* **Required JAR Files:**
  * `mysql-connector-j-8.4.0`
  * `jcalendar-1.4`
  * `rs2xml`
  * `RSCalendar`

---

## Database Configuration (`tablemanagement`)

The system uses a MySQL database named `tablemanagement` with 3 core tables:

1. **`users`**: Stores user registration details (username, password, email, contact).
2. **`tablemanager`**: Stores table counts, seat capacities, and pricing configurations for all zones.
3. **`customermanager`**: Stores customer booking records, assigned tables, pricing, and submission timestamps.

---
## Setup and Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/LahiruButhsara34/Restaurant-Table-Reservation-System-with-java.git


---

## User Manual

[Download User Manual (PDF)](Design_Explanation%20%28XYZ%20Restaurant%29.pdf)
