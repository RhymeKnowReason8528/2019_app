package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Motor Test")
public class MotorTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap);
        double pi = robot.pi;

        waitForStart();
        robot.runtime.reset();

        while (opModeIsActive()) {
            robot.drive.allMotors(0);
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
                robot.drive.frontRightMotor(1);
            } else if (gamepad1.right_trigger >= 0.5) {
                robot.drive.backLeftMotor(-1);
                robot.drive.backRightMotor(1);
                robot.drive.frontLeftMotor(-1);
                robot.drive.frontRightMotor(1);
            } else if (gamepad1.left_trigger >= 0.5) {
                robot.drive.backLeftMotor(1);
                robot.drive.backRightMotor(-1);
                robot.drive.frontLeftMotor(1);
                robot.drive.frontRightMotor(-1);
            }
            if (gamepad1.a) {robot.drive.backLeftMotor(1);}
            if (gamepad1.b) {robot.drive.backRightMotor(1);}
            if (gamepad1.y) {robot.drive.frontRightMotor(1);}
            if (gamepad1.x) {robot.drive.frontLeftMotor(1);}

            telemetry.addData("Runtime: ", robot.runtime);
            telemetry.addData("This is pi: ", pi);
            telemetry.update();
        }
    }
}