
<h1 align="center">Crime Investigation Portal</h1>

<p align="center">
  <strong>A Java Swing desktop prototype for reporting and managing fictional cases.</strong><br />
  An academic project exploring desktop interfaces, role-specific workflows, and local persistence.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-0F766E?style=flat-square&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/UI-Java%20Swing-17252A?style=flat-square" alt="Java Swing" />
  <img src="https://img.shields.io/badge/Storage-Local%20Files-0F766E?style=flat-square" alt="Local files" />
  <img src="https://img.shields.io/badge/Type-Academic%20Prototype-263238?style=flat-square" alt="Academic prototype" />
</p>

<p align="center">
  <a href="#overview">Overview</a> ·
  <a href="#features">Features</a> ·
  <a href="#application-screenshots">Screenshots</a> ·
  <a href="#getting-started">Getting Started</a>
</p>

---

## Overview

**Crime Investigation Portal** is a desktop application developed using **Java and Swing**. It models a fictional crime-reporting workflow with separate victim, administrator, and investigator interfaces.

The project demonstrates GUI event handling, object-oriented programming, case records, and local file operations. It is not connected to police, emergency services, or a production backend.

## Features

| Interface | Implemented functionality |
| --- | --- |
| Welcome screen | Navigate between victim, administrator, and investigator flows |
| Victim | Complete a crime report form and receive a case ID |
| Administrator | View reports, assign investigators, and update case status |
| Investigator | View assigned cases, inspect details, and update case status |
| Case tracking | Look up case information through the application interface |
| Local persistence | Store and load report information using local files |

The report form includes incident and crime categories, incident details, evidence path selection, and consent checkboxes.

## Application Screenshots

<p align="center">
  <img src="screenshots/welcome-screen.png" alt="Welcome screen" width="540" />
  <br /><sub>Welcome Screen</sub>
</p>

<p align="center">
  <img src="screenshots/crime-report-form.png" alt="Crime report form" width="540" />
  <br /><sub>Crime Report Form</sub>
</p>

<details>
<summary><strong>View Dashboard Screenshots</strong></summary>

<p align="center">
  <img src="screenshots/admin-dashboard.png" alt="Administrator dashboard" width="540" />
  <br /><sub>Administrator Dashboard</sub>
</p>

<p align="center">
  <img src="screenshots/investigator-dashboard.png" alt="Investigator dashboard" width="540" />
  <br /><sub>Investigator Dashboard</sub>
</p>

</details>

## Technologies & Concepts

<p>
  <img src="https://skillicons.dev/icons?i=java&theme=dark" alt="Java programming language" height="44" />
</p>

- **Language:** Java
- **GUI:** Java Swing
- **Development tools:** IntelliJ IDEA, VS Code
- **Concepts:** Object-oriented programming, classes, event handling, desktop UI design, and file I/O
- **Data storage:** Local file-based report storage

## Getting Started

### Requirements

- Java Development Kit (JDK)
- A terminal or a Java-compatible IDE
- A desktop operating system with GUI support

### Compile and Run

Open the folder containing `Main.java` and the other Java source files.

On a Unix-like terminal:

```bash
javac *.java
java Main
```

Alternatively, open the source folder in VS Code or IntelliJ IDEA and run `Main.java`.

### Basic Workflow

1. Launch the application.
2. Select a role from the welcome screen.
3. As a **Victim**, submit a fictional test report.
4. As an **Administrator**, review cases and assign an investigator.
5. As an **Investigator**, view assigned cases and update their status.

Use fictional information only. Demo authentication is hardcoded and must not be treated as secure access control.

## Project Structure

```text
crime-investigation-portal-java/
├── Main.java
├── WelcomeFrame.java
├── VictimDashboard.java
├── CrimeReportForm.java
├── CrimeReport.java
├── ReportService.java
├── CaseTrackingFrame.java
├── AdminLoginFrame.java
├── AdminDashboard.java
├── InvestigatorLoginFrame.java
├── InvestigatorDashboard.java
├── screenshots/
│   ├── welcome-screen.png
│   ├── crime-report-form.png
│   ├── admin-dashboard.png
│   └── investigator-dashboard.png
├── .gitignore
└── README.md
```

## What I Practiced

- Designing graphical interfaces using Java Swing
- Applying object-oriented programming principles
- Managing user interactions through event handling
- Organizing application functionality into multiple classes
- Managing case information using file operations
- Documenting software functionality with screenshots

## Limitations

- Emergency-type reports do not contact emergency services.
- Evidence selection records a file path; it does not upload the file.
- Login credentials are hardcoded for demonstration.
- Report storage is local, without a database or online synchronization.
- Case ID generation and input validation are not designed for production use.

**This application is an educational prototype, not an official crime-reporting system.**

## Future Improvements

- Secure authentication and authorization
- Database integration
- Stronger input validation
- Collision-resistant case IDs
- Automated testing and error handling
- Controlled evidence storage and access permissions

---

<p align="center">
  <a href="https://github.com/saimumfahad-dev">GitHub Profile</a> ·
  <a href="https://www.linkedin.com/in/md-saimum-islam-fahad/">LinkedIn</a>
  <br />
  <sub>Built for learning · Code · Build · Learn</sub>
</p>
