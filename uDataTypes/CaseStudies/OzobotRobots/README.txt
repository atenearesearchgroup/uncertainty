a) For the Robot with Plain UML:

* MovingRobot.use: specs of the Robot using plain UML (ie. w/o Uncertainty)
* MovingRobot_default.clt: diagrammatic info for these specs
* Robot.soil: set of SOIL commands to execute the MovingRobot.use specs
* Robot-output.txt: output of executing the SOIL commands

To execute these specs, in the USE/OCL console, execute:

use> open MovingRobot.use
use> open Robot.soil

a) For the Robot with uncertainty (you need the USE environment with support for Uncertainty).

* UMovingRobot.use: specs of the Robot using Uncertainty
* UMovingRobot.clt: diagrammatic info for these specs
* URobot.soil: set of SOIL commands to execute the UMovingRobot.use specs
* URobot-output.txt: output of executing the SOIL commands

To execute these specs, in the USE/OCL console, execute:

use> open UMovingRobot.use
use> open Robot.soil

