package com.aqiang.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrower {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://pmbp2.local:8443/avc2/index.action");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("David");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("David");
		WebElement findElement = driver.findElement(By.className("btn-submit"));
		findElement.click();
		WebElement findElement2 = driver.findElement(By.id("logoutLink"));
		findElement2.click();
		driver.close();
	}
}
