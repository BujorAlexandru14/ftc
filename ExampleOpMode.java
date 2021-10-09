package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="ExampleOpMode", group="TeleOp")
public class ExampleOpMode extends OpMode
{
    DcMotor leftMotor;

    DcMotor rightMotor;

    double leftWheelPower;

    double rightWheelPower;

    Servo leftClaw;

    Servo rightClaw;

    @Override
    public void init() {

        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");

        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        leftClaw = hardwareMap.servo.get("left_claw");

        rightClaw = hardwareMap.servo.get("right_claw");

        leftMotor.setDirection(DcMotor.Direction.FORWARD);

        rightMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

        leftWheelPower = gamepad1.left_stick_y;

        rightWheelPower = gamepad1.right_stick_y;

        leftMotor.setPower(leftWheelPower);

        rightMotor.setPower(rightWheelPower);

        if (gamepad1.x) {
            leftClaw.setPosition(1);

            rightClaw.setPosition(1);
        }
        else {
            leftClaw.setPosition(0);

            rightClaw.setPosition(0);
        }
    }
}