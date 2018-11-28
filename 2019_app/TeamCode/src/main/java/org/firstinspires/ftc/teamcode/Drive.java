package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Drive")
public class Drive extends LinearOpMode {
    @Override
    public void runOpMode() {

        Robot robot = new Robot(hardwareMap);
        waitForStart();
        robot.runtime.reset();

        //boolean AutoDrive; TODO: Add this functionality now
        while (opModeIsActive()) {
            robot.drive.emptyMotors();

            //Dpad Controls ------------------------------------------------------------------------
            if (gamepad1.dpad_up) {
                robot.drive.allMotors(1);
            } else if (gamepad1.dpad_down) {
                robot.drive.allMotors(-1);
            } else if (gamepad1.dpad_right) {
                robot.drive.backLeftMotor(-1);
                robot.drive.backRightMotor(1);
                robot.drive.frontLeftMotor(1);
                robot.drive.frontRightMotor(-1);
            } else if (gamepad1.dpad_left) {
                robot.drive.backLeftMotor(1);
                robot.drive.backRightMotor(-1);
                robot.drive.frontLeftMotor(-1);
                robot.drive.frontRightMotor(1);}
            //End of Dpad Controls -----------------------------------------------------------------

            //Joystick Controls --------------------------------------------------------------------
            robot.drive.leftSide(gamepad1.left_stick_y);
            robot.drive.rightSide(gamepad1.right_stick_y);
            //End of Joystick Controls -------------------------------------------------------------

            //Trigger Controls ---------------------------------------------------------------------
            robot.drive.undeterminedTurnLeft(gamepad1.left_trigger);
            robot.drive.undeterminedTurnRight(gamepad1.right_trigger);
            //End of Trigger Controls --------------------------------------------------------------

            telemetry.addData("Runtime: ", robot.runtime);
            telemetry.update();//github test 2
        }
    }
}