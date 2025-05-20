# Manual test results for Visuals and Joystick

## Joystick

### Test Metadata

| Field           | Value                            |
|-----------------|----------------------------------|
| Tester Name     | [Your Name]                      |
| Test Date       | 20/05/2025                       |
| Environment     | [e.g., Windows 11, Ubuntu 22.04] |
| Java Version    | 23.0.2                           |
| Maven Version   | 3.9.9                            |
| Game Version    | [v1.0.0 or commit hash]          |
| Input Device    | Analog Joystick                  |
| File Under Test | View.java                        |

---

### Test Case Execution

#### Test Case ID: TC001 – Idle State

| Step | Action                | Expected Result                | Actual Result   | Pass/Fail | Notes            |
|------|-----------------------|--------------------------------|-----------------|-----------|------------------|
| 1    | Launch the game       | Game loads and shows character | [actual result] | [ ]       | [optional notes] |
| 2    | Do not touch joystick | Character remains still        | [actual result] | [ ]       |                  |

---

#### Test Case ID: TC002 – Move Up

| Step | Action               | Expected Result        | Actual Result   | Pass/Fail | Notes |
|------|----------------------|------------------------|-----------------|-----------|-------|
| 1    | Push joystick upward | Character moves upward | [actual result] | [ ]       |       |
| 2    | Release joystick     | Character stops moving | [actual result] | [ ]       |       |

---

### Test Case ID: TC003 – Move Down

| Step | Action                 | Expected Result          | Actual Result   | Pass/Fail | Notes |
|------|------------------------|--------------------------|-----------------|-----------|-------|
| 1    | Push joystick downward | Character moves downward | [actual result] | [ ]       |       |
| 2    | Release joystick       | Character stops moving   | [actual result] | [ ]       |       |

---

### Test Case ID: TC004 – Move Left

| Step | Action             | Expected Result        | Actual Result   | Pass/Fail | Notes |
|------|--------------------|------------------------|-----------------|-----------|-------|
| 1    | Push joystick left | Character moves left   | [actual result] | [ ]       |       |
| 2    | Release joystick   | Character stops moving | [actual result] | [ ]       |       |

---

### Test Case ID: TC005 – Move Right

| Step | Action              | Expected Result        | Actual Result   | Pass/Fail | Notes |
|------|---------------------|------------------------|-----------------|-----------|-------|
| 1    | Push joystick right | Character moves right  | [actual result] | [ ]       |       |
| 2    | Release joystick    | Character stops moving | [actual result] | [ ]       |       |

---

### Test Case ID: TC006 – Diagonal Movement

| Step | Action                                    | Expected Result            | Actual Result   | Pass/Fail | Notes |
|------|-------------------------------------------|----------------------------|-----------------|-----------|-------|
| 1    | Push joystick diagonally (e.g., up-right) | Character moves diagonally | [actual result] | [ ]       |       |
| 2    | Release joystick                          | Character stops moving     | [actual result] | [ ]       |       |

---

### Test Case ID: TC007 – Analog Sensitivity

| Step | Action                                     | Expected Result                                 | Actual Result   | Pass/Fail | Notes |
|------|--------------------------------------------|-------------------------------------------------|-----------------|-----------|-------|
| 1    | Slightly tilt joystick (e.g., 25% forward) | Character moves slowly in intended direction    | [actual result] | [ ]       |       |
| 2    | Push joystick fully in same direction      | Character moves at full speed in that direction | [actual result] | [ ]       |       |

---

### Summary

| Total Test Cases | Passed | Failed | Blocked |
|------------------|--------|--------|---------|
| 7                | [#]    | [#]    | [#]     |

### Observations

- [e.g., Minor delay when releasing joystick]
- [e.g., Diagonal movement is slightly faster than expected]

### Recommendations

- [Optional: Improvements, bug reports, etc.]

# Visuals

## Test Metadata

| Field           | Value                            |
|-----------------|----------------------------------|
| Tester Name     | [Your Name]                      |
| Test Date       | 20/05/2025                       |
| Environment     | [e.g., Windows 11, Ubuntu 22.04] |
| Java Version    | 23.0.2                           |
| Maven Version   | 3.9.9                            |
| Game Version    | [v1.0.0 or commit hash]          |
| Input Device    | Barcode Scanner                  |
| File Under Test | View.java                        |

---

### Test Case ID: TC001 – Start Screen

| Step | Action          | Expected Result                                                                                                                                                                                      | Actual Result   | Pass/Fail | Notes |
|------|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------|-----------|-------|
| 1    | Launch the game | There should be a blue background with backLayer.png, middleLayer.png, and frontLayer.png. A floating barcode scanner image should appear along with a prompt to scan a barcode on a clothing piece. | [actual result] | [ ]       |       |

---

### Test Case ID: TC002 – Starting Animation

| Step | Action                             | Expected Result                                                                                                                                                                                                          | Actual Result   | Pass/Fail | Notes |
|------|------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------|-----------|-------|
| 1    | Scan a barcode on a clothing piece | The barcode scanner image should disappear. An animation with a washing machine (based on scanned clothing) should play. Background should scroll left with parallax. Two player characters should swim into the screen. | [actual result] | [ ]       |       |

---

### Test Case ID: TC003 – Running

| Step | Action                            | Expected Result                                                                                                        | Actual Result   | Pass/Fail | Notes |
|------|-----------------------------------|------------------------------------------------------------------------------------------------------------------------|-----------------|-----------|-------|
| 1    | Wait for the running phase to end | Players and background should still be present. Plastic pieces (no animation yet) should float in from the right side. | [actual result] | [ ]       |       |

---

### Test Case ID: TC004 – End

| Step | Action                        | Expected Result                                     | Actual Result   | Pass/Fail | Notes |
|------|-------------------------------|-----------------------------------------------------|-----------------|-----------|-------|
| 1    | Wait for the end phase to end | Players should swim out of the screen to the right. | [actual result] | [ ]       |       |

---

### Test Case ID: TC005 – HighScore

| Step | Action                        | Expected Result                                                                   | Actual Result   | Pass/Fail | Notes |
|------|-------------------------------|-----------------------------------------------------------------------------------|-----------------|-----------|-------|
| 1    | Wait for the HighScore to end | A scoreboard should appear showing the top 10 scores and your score in comparison | [actual result] | [ ]       |       |

---

## Summary

| Total Test Cases | Passed | Failed | Blocked |
|------------------|--------|--------|---------|
| 5                | [#]    | [#]    | [#]     |

## Observations

- [e.g., Front layer image not loading]
- [e.g., Player animation swims in too early]

## Recommendations

- [e.g., Add fallback visuals if image fails to load]
- [e.g., Improve transition smoothness between phases]

## Postconditions

- After HighScore screen, the start animation should loop again as expected.
