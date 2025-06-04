# Reinstallation / Recreation Guide

## Inhalt

- [Hardware](#hardware)
    - [Recreating the Arcade Box](#recreating-the-arcade-box)
        - [Tools](#tools)
        - [Material](#material)
        - [Process](#process)
- [Electronics](#electronics)
    - [Raspberry Pi](#raspberry-pi)
        - [Tools](#tools-1)
        - [Process](#process-1)
    - [Monitor](#monitor)
        - [Tools](#tools-2)
        - [Process](#process-2)
    - [Joysticks](#joysticks)
        - [Tools](#tools-3)
        - [Process](#process-3)
- [Software](#software)
    - [Reinstallation](#reinstallation)
        - [Tools](#tools-4)
        - [Process](#process-4)

---

## Hardware

### Recreating the Arcade Box
[Our Plan](../hardware/BT800-700_report.pdf)
#### Tools

- Milling machine (preferably with a guide, e.g., Fastool)
- Plunge saw and guide (e.g., Fastool)
- Jigsaw (e.g., Bosch)
- Hinges (any)
- Screws (not too long)
- Screw clamps (preferably multiple)
- Sandpaper and sandpaper block (120, 180, 240 grit)
- Laser cutter
- Any paint (used for marking, not decoration)
- Hammer
- Chisel (thinner than wood board)

#### Material

- Wood (appearance depends on type)
- Wood glue
- Power switch

#### Process

##### Step 1: Rough Pieces

Cut the following pieces:

- RIGHT SIDE PANEL_R2
- LEFT SIDE PANEL_R2
- CONTROL PANEL_R2
- BACK DOOR_R2
- BOTTOM PANEL_R2
- SPEAKER PANEL_R2
- BOTTOM FRONT COVER_R2
- TOP FRONT COVER_R2
- BACK BOTTOM PIECE_R2
- TOP PANEL_R2

Use a cut list optimizer like [cutlistoptimizer.com](https://cutlistoptimizer.com) for planning.

Use a plunge saw to cut out. Note: The top panel and back door require angled cuts.

##### Step 2: Side Panels

1. Use a laser cutter to create a side panel template (SVG is saved with this document).
2. Rough cut with a jigsaw; refine with a milling machine using the template.
3. Place components on side panels and draw outlines.
4. Mill 5mm deep indents using a guide, clean corners with hammer and chisel.
5. Apply paint to one panel’s indents and press against the other to transfer outlines. Repeat milling.

##### Step 3: Monitor Panel and Power Switch

- Drill and mill the Back Bottom panel for power switch, then attach it.
- Assemble box to measure monitor space. Cut a new panel to size.
- Mark monitor dimensions, then draw a smaller inner box (~4mm inset).
- Cut inner box; mill outer box for the monitor to rest against.

##### Step 4: Gluing

- Glue the indent-mounted components first.
- Then glue the remaining parts (except back door).
- Finally glue the second side panel on.

##### Step 5: Back Door

- Attach the back door with 2+ hinges to the back bottom piece (the bottom to reduce load).

---

## Electronics

### Raspberry Pi

#### Tools


#### Process


---

### Monitor

#### Tools


#### Process


---

### Joysticks

#### Tools


#### Process


---

## Software

### Installation

#### Tools

- Maven 3.9.9
- Java 21.0.4
- Debian GNU/Linux 12 (Bookworm)

#### Process

##### Step 1: Code

1. Clone the Git repository.
2. Add pom.xml as a Maven project.
3. Run:  
   mvn clean install
4. To run locally, execute the main() in App.java.
5. To deploy to the Pi:
    - Ensure Pi and your PC are on the same network.
    - Edit line 34 in pom.xml to use your Pi’s IP.
    - Select the "run on pi" Maven profile.
    - Run the project.

##### Step 2: Auto Start on Pi
For the autostart we wrote a script called [gameStarterScript.sh](https://gitlab.fhnw.ch/ip12-24vt/ip12-24vt_ueberduengung/ueberduengung/-/blob/dev/src/assembly/gameStarterScript.sh?ref_type=heads) that we place automatically under */home/pi/*


##### Create a systemd Service File
Create a new service file:
```sh
cd ~
chmod +x /home/deploy/gameStarterScript.service
mkdir .config/systemd/users/
sudo mv deploy/Ueberduengung/gameStarterScript .config/systemd/users/gameStarterScript.service
```

##### Enable and Start the Service
Reload `systemd`, enable the service, and start it:
```sh
sudo loginctl enable-linger pi
systemctl --user daemon-reload
systemctl enable --user gameStarterScript.service
systemctl start --user gameStarterScript.service
```

##### Check Status
Verify the service is running and enabled:
```sh
systemctl --user status gameStarterScript.service
```