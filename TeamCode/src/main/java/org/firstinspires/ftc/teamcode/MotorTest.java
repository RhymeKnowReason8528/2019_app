package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Motor Test")
public class MotorTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap);

        waitForStart();
        robot.runtime.reset();

        while (opModeIsActive()) {
            robot.allMotors(0);
            if (gamepad1.dpad_up) {
                robot.allMotors(1);
            } else if (gamepad1.dpad_down) {
                robot.allMotors(-1);
            } else if (gamepad1.dpad_right) {
                robot.backLeftMotor(-1);
                robot.backRightMotor(1);
                robot.frontLeftMotor(1);
                robot.frontRightMotor(-1);
            } else if (gamepad1.dpad_left) {
                robot.backLeftMotor(1);
                robot.backRightMotor(-1);
                robot.frontLeftMotor(-1);
                robot.frontRightMotor(1);
            } else if (gamepad1.right_trigger >= 0.5) {
                robot.backLeftMotor(-1);
                robot.backRightMotor(1);
                robot.frontLeftMotor(-1);
                robot.frontRightMotor(1);
            } else if (gamepad1.left_trigger >= 0.5) {
                robot.backLeftMotor(1);
                robot.backRightMotor(-1);
                robot.frontLeftMotor(1);
                robot.frontRightMotor(-1);
            }
            if (gamepad1.a) {robot.backLeftMotor(1);}
            if (gamepad1.b) {robot.backRightMotor(1);}
            if (gamepad1.y) {robot.frontRightMotor(1);}
            if (gamepad1.x) {robot.frontLeftMotor(1);}

            telemetry.addData("Runtime: ", robot.runtime);
            telemetry.update();
        }
    }
}