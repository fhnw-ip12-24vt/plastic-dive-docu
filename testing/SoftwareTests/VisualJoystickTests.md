# Manual tests for Visuals and Joystick

## Joystick

### Project Information

| Item              | Details                 |
|-------------------|-------------------------|
| Test Title        | Character Movement Test |
| System Under Test | Player.Java             |
| Language          | Java 23.0.2             |
| Build Tool        | Maven 3.9.9             |
| Input Device      | Joystick (Single Stick) |
| Test Type         | Manual Functional Test  |
| Prepared By       | Michael Galambos        |
| Date              | 20/05/2025              |

### Test Objective

To verify that the player moves accurately in all directions based of a joystick input.

### Preconditions

- The game project builds and runs without error.
- A compatible joystick is connected and recognized by the system.
- The joystick is calibrated and functional.
- The game is running and in the running phase.

#### Test Scenarios

##### TC001 – Idle State

| Step | Action                                           | Expected Result                                 |
|------|--------------------------------------------------|-------------------------------------------------|
| 1    | Launch the game and proceed to the running phase | Game loads and shows player character on screen |
| 2    | Do not touch the joystick                        | Character remains stationary                    |

---

##### TC002 – Move Up

| Step | Action                     | Expected Result             |
|------|----------------------------|-----------------------------|
| 1    | Push joystick fully upward | Character moves upward      |
| 2    | Release joystick           | Character stops immediately |

---

##### TC003 – Move Down

| Step | Action                       | Expected Result             |
|------|------------------------------|-----------------------------|
| 1    | Push joystick fully downward | Character moves downward    |
| 2    | Release joystick             | Character stops immediately |

---

##### TC004 – Move Left

| Step | Action                   | Expected Result             |
|------|--------------------------|-----------------------------|
| 1    | Push joystick fully left | Character moves left        |
| 2    | Release joystick         | Character stops immediately |

---

##### C005 – Move Right

| Step | Action                    | Expected Result             |
|------|---------------------------|-----------------------------|
| 1    | Push joystick fully right | Character moves right       |
| 2    | Release joystick          | Character stops immediately |

---

##### TC006 – Diagonal Movement

| Step | Action                                     | Expected Result                         |
|------|--------------------------------------------|-----------------------------------------|
| 1    | Push joystick diagonally (e.g., top-right) | Character moves in a diagonal direction |
| 2    | Release joystick                           | Character stops immediately             |

---

##### TC007 – Analog Sensitivity

| Step | Action                                | Expected Result                                  |
|------|---------------------------------------|--------------------------------------------------|
| 1    | Slightly tilt joystick (e.g., 25%)    | Character moves slowly in the intended direction |
| 2    | Push joystick fully in same direction | Character moves at full speed in that direction  |

---

### Postconditions

- No unexpected movement or drift occurs after releasing joystick.
- ### Project Information

| Item              | Details                 |
|-------------------|-------------------------|
| Test Title        | Character Movement Test |
| System Under Test | Player.Java             |
| Language          | Java 23.0.2             |
| Build Tool        | Maven 3.9.9             |
| Input Device      | Joystick (Single Stick) |
| Test Type         | Manual Functional Test  |
| Prepared By       | Michael Galambos        |
| Date              | 20/05/2025              |

### Test Objective

To verify that the player moves accurately in all directions based of a joystick input.

### Preconditions

- The game project builds and runs without error.
- A compatible joystick is connected and recognized by the system.
- The joystick is calibrated and functional.
- The game is running and in the running phase.

#### Test Scenarios

##### TC001 – Idle State

| Step | Action                                           | Expected Result                                 |
|------|--------------------------------------------------|-------------------------------------------------|
| 1    | Launch the game and proceed to the running phase | Game loads and shows player character on screen |
| 2    | Do not touch the joystick                        | Character remains stationary                    |

---

##### TC002 – Move Up

| Step | Action                     | Expected Result             |
|------|----------------------------|-----------------------------|
| 1    | Push joystick fully upward | Character moves upward      |
| 2    | Release joystick           | Character stops immediately |

---

##### TC003 – Move Down

| Step | Action                       | Expected Result             |
|------|------------------------------|-----------------------------|
| 1    | Push joystick fully downward | Character moves downward    |
| 2    | Release joystick             | Character stops immediately |

---

##### TC004 – Move Left

| Step | Action                   | Expected Result             |
|------|--------------------------|-----------------------------|
| 1    | Push joystick fully left | Character moves left        |
| 2    | Release joystick         | Character stops immediately |

---

##### C005 – Move Right

| Step | Action                    | Expected Result             |
|------|---------------------------|-----------------------------|
| 1    | Push joystick fully right | Character moves right       |
| 2    | Release joystick          | Character stops immediately |

---

##### TC006 – Diagonal Movement

| Step | Action                                     | Expected Result                         |
|------|--------------------------------------------|-----------------------------------------|
| 1    | Push joystick diagonally (e.g., top-right) | Character moves in a diagonal direction |
| 2    | Release joystick                           | Character stops immediately             |

---

##### TC007 – Analog Sensitivity

| Step | Action                                | Expected Result                                  |
|------|---------------------------------------|--------------------------------------------------|
| 1    | Slightly tilt joystick (e.g., 25%)    | Character moves slowly in the intended direction |
| 2    | Push joystick fully in same direction | Character moves at full speed in that direction  |

---

### Postconditions

- No unexpected movement or drift occurs after releasing joystick.

## Visuals

### Project Information

| Item              | Details                |
|-------------------|------------------------|
| Test Title        | Visuals Test           |
| System Under Test | View.Java              |
| Language          | Java 23.0.2            |
| Build Tool        | Maven 3.9.9            |
| Input Device      | Barcode Scanner        |
| Test Type         | Manual Functional Test |
| Prepared By       | Michael Galambos       |
| Date              | 20/05/2025             |

### Test Objective

To verify that the correct visuals are shown in the correct places at the correct times.

### Preconditions

- The game project builds and runs without error.
- A compatible joystick is connected and recognized by the system.
- The joystick is calibrated and functional.
- The game is running.

#### Test Scenarios

##### TC001 – Start Screen

| Step | Action          | Expected Result                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
|------|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1    | Launch the game | There should be a blue background with the [backLayer.png](https://gitlab.fhnw.ch/ip12-24vt/ip12-24vt_ueberduengung/ueberduengung/-/blob/dev/src/main/resources/assets/frontLayer.png?ref_type=heads), [middleLayer.png](https://gitlab.fhnw.ch/ip12-24vt/ip12-24vt_ueberduengung/ueberduengung/-/blob/dev/src/main/resources/assets/middleLayer.png?ref_type=heads) and [frontLayer.png](https://gitlab.fhnw.ch/ip12-24vt/ip12-24vt_ueberduengung/ueberduengung/-/blob/dev/src/main/resources/assets/frontLayer.png?ref_type=heads) there should also be a floating [barcode scanner](https://gitlab.fhnw.ch/ip12-24vt/ip12-24vt_ueberduengung/ueberduengung/-/blob/dev/src/main/resources/assets/barcodeScanner.png?ref_type=heads) with a text prompting a player to scan a barcode on a clothing piece. |

---

##### TC002 – Starting Animation

| Step | Action                              | Expected Result                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
|------|-------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1    | Scan a bar code on a clothing piece | the floating barcode should disappear and instead there should be an [animation with a washing machine](https://gitlab.fhnw.ch/ip12-24vt/ip12-24vt_ueberduengung/ueberduengung/-/blob/dev/src/main/resources/assets/washingMachineEasy.png?ref_type=heads) based on what clothing you scanned. Near the and the background should move with a parallax towards the left and the 2 [player animations](https://gitlab.fhnw.ch/ip12-24vt/ip12-24vt_ueberduengung/ueberduengung/-/blob/dev/src/main/resources/assets/player.png?ref_type=heads) should swim into the screen. |

---

##### TC003 – Running

| Step | Action                            | Expected Result                                                                                                             |
|------|-----------------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| 1    | Wait for the running phase to end | In addition to the players and the background there should be (plastic pieces)[no animation yet] floating in from the right |

---

##### TC004 – End

| Step | Action                        | Expected Result                                         |
|------|-------------------------------|---------------------------------------------------------|
| 1    | Wait for the end phase to end | The players should swim out of the screen on the rights |

---

##### C005 – HighScore

| Step | Action                        | Expected Result                                                                            |
|------|-------------------------------|--------------------------------------------------------------------------------------------|
| 1    | Wait for the HighScore to end | There should be a scoreboard showing up sowing the 10  best scores and yours in comparison |

---

### Postconditions
The starting animations should start again