package com.base.demo.design.observer.impl;

import com.base.demo.design.observer.DisplayElement;
import com.base.demo.design.observer.Observer;

/**
 * 显示当前天气的公告牌C
 *
 * @author tangwei
 * @date 2019/3/6 19:38
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    private WeatherData weatherData;
    private float temperature;//温度
    private float humidity;//湿度
    private float pressure;//气压

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("今天的温度是" + temperature + "℃");
        System.out.println("今天的湿度是" + humidity);
        System.out.println("今天的气压是" + pressure);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();
        display();
    }

}
