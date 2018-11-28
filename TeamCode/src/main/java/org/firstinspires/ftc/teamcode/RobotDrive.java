package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotDrive {
    private DcMotor frontLeftDrive;
    private DcMotor frontRightDrive;
    private DcMotor backLeftDrive;
    private DcMotor backRightDrive;

    RobotDrive(HardwareMap map) {
        frontLeftDrive = map.dcMotor.get("front_left_drive");
        backLeftDrive = map.dcMotor.get("back_left_drive");
        frontRightDrive = map.dcMotor.get("front_right_drive");
        backRightDrive = map.dcMotor.get("back_right_drive");

        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        frontRightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeftDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
    }

    void emptyMotors() {frontLeftDrive.setPower(0);backRightDrive.setPower(0);backLeftDrive.setPower(0);frontRightDrive.setPower(0);}

    void frontLeftMotor(double powerLevel) {
        frontLeftDrive.setPower(powerLevel/2);
    }

    void backLeftMotor(double powerLevel) {
        backLeftDrive.setPower(powerLevel/2);
    }

    void frontRightMotor(double powerLevel) {
        frontRightDrive.setPower(powerLevel/2);
    }

    void backRightMotor(double powerLevel) {
        backRightDrive.setPower(powerLevel/2);
    }

    void allMotors(double powerLevel) {
        backLeftDrive.setPower(powerLevel/2);
        backRightDrive.setPower(powerLevel/2);
        frontLeftDrive.setPower(powerLevel/2);
        frontRightDrive.setPower(powerLevel/2);
    }

    void leftSide(double powerLevel) {
        backLeftDrive.setPower(powerLevel/2);
        frontLeftDrive.setPower(powerLevel/2);
    }

    void rightSide(double powerLevel) {
        backRightDrive.setPower(powerLevel/2);
        frontRightDrive.setPower(powerLevel/2);
    }

    void undeterminedTurnRight(double powerLevel) {
        backLeftDrive.setPower(-powerLevel/2);
        backRightDrive.setPower(powerLevel/2);
        frontLeftDrive.setPower(-powerLevel/2);
        frontRightDrive.setPower(powerLevel/2);
    }

    void undeterminedTurnLeft(double powerLevel) {
        backLeftDrive.setPower(powerLevel/2);
        backRightDrive.setPower(-powerLevel/2);
        frontLeftDrive.setPower(powerLevel/2);
        frontRightDrive.setPower(-powerLevel/2);
    }
}