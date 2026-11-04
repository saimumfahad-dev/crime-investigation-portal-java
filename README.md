
# Crime Investigation Portal (Java Swing)

A desktop-based **crime reporting and case management prototype** developed in Java as an academic software project. It provides separate interfaces for victims, administrators, and investigators to demonstrate report submission, case assignment, status updates, and case tracking.

> **Academic demonstration only.** This application is not connected to law enforcement or emergency services. It must not be used to submit real crime reports or handle sensitive personal information.

## Features

### Victim interface

- Submit a crime report with incident type, category, date, time, location, and description.
- Optionally enter suspect, victim, and witness information.
- Select an evidence file path using a file chooser (the file itself is **not uploaded or copied**).
- Confirm the form's three consent checkboxes before submitting.
- Receive a generated case ID and track a case by that ID.

### Administrator interface

- View saved reports in a table.
- Assign an investigator to a selected case.
- Update case status (for example, *Under Review*, *Investigation Started*, or *Closed*).
- Refresh the dashboard to display current locally stored records.

### Investigator interface

- View cases assigned to the signed-in investigator name.
- Review the details of an assigned case.
- Update a case's status to *Investigation Started*, *Evidence Requested*, or *Closed*.

## Tech stack

- **Language:** Java
- **GUI:** Java Swing and AWT
- **Data storage:** Local text file (`reports.txt`)
- **Dependencies:** Java standard library only; no external libraries or database required

## Getting started

### Requirements

- A Java Development Kit (JDK), version 8 or newer
- A desktop environment capable of displaying Java Swing windows

### Compile and run

The Java source files are currently stored at the root of this repository.

From a terminal in the repository folder, compile the source files:

```bash
javac *.java
```

Start the application:

```bash
java Main
```

The welcome screen offers three roles: **Victim**, **Admin**, and **Investigator**. Admin and investigator authentication currently use hardcoded **demonstration credentials** in their respective login classes; this is not secure authentication.

## Example workflow

1. Select **Victim** and open **Submit Crime Report**.
2. Complete the required fields, accept the consent checkboxes, and submit a sample report.
3. Record the displayed case ID.
4. Use **Track Case** to look up the report and its current status.
5. Open the **Admin** interface to assign an investigator and change its status.
6. Open the **Investigator** interface to view cases assigned to that login and update their status.

Use fictional sample details only.

## Project structure

| File | Purpose |
| --- | --- |
| `Main.java` | Application entry point |
| `WelcomeFrame.java` | Role selection and navigation |
| `VictimDashboard.java` | Victim menu for report submission and tracking |
| `CrimeReportForm.java` | Report input form, validation, and submission |
| `CaseTrackingFrame.java` | Case lookup by case ID |
| `CrimeReport.java` | Report data model and text serialization |
| `ReportService.java` | Case ID generation, local storage, lookup, assignment, and status updates |
| `AdminLoginFrame.java` | Demo administrator login |
| `AdminDashboard.java` | Report table, investigator assignment, and case status management |
| `InvestigatorLoginFrame.java` | Demo investigator login |
| `InvestigatorDashboard.java` | Assigned-case list, case details, and status updates |

## How data is stored

- Records are saved locally to `reports.txt` in the application's current working directory.
- Each report is stored as a single pipe-separated line.
- Case IDs are generated using the current timestamp, such as `CASE-20261105123045`.
- Report updates rewrite the saved report list.
- The selected evidence file is stored only as a path string; the evidence file itself is not copied into the project.

**Do not commit `reports.txt` to GitHub.** It may contain personal information. Add `reports.txt` to `.gitignore` before creating sample reports.

## Known limitations

This is a learning project, not a production-ready crime reporting system:

- Admin and investigator logins use hardcoded demonstration credentials.
- Report data is stored as unencrypted local text, without a secure database or access control.
- Case IDs use second-resolution timestamps and may collide when reports are submitted within the same second.
- Input validation and error reporting for storage operations are limited.
- Evidence selection records a file path; there is no actual evidence upload or file transfer.
- **No real emergency notification is sent.** The original report form displayed a misleading notification message; the corrected `CrimeReportForm.java` explicitly states that the demo does not contact emergency services.
- The application has no networking backend, multi-user synchronization, or automated tests in the provided source.

## Possible future improvements

- Replace hardcoded credentials with proper authentication and role-based access control.
- Add a database and safer report storage with appropriate privacy protections.
- Generate collision-resistant case IDs.
- Validate input formats and confirm successful report saves before showing success messages.
- Add automated tests and improved error handling.
- Implement proper evidence storage and controlled access, if appropriate for a secure demonstration.

## Author

**Md Saimum Islam Fahad**  
Computer Science & Engineering Undergraduate, North South University  
[LinkedIn](https://www.linkedin.com/in/md-saimum-islam-fahad/)
  
