import React, { Component } from 'react';
import './App.css';
import ReactDOM from 'react-dom';

function tick() {
    const element = (
        <div className="body">
            <div className="app">
                <div className="title">
                    <h1>Россіянинъ</h1><h2 className="title__page">Добро пожаловать</h2>
                </div>
                <div className="login">
                    <h1>Вы одинъ въ сѣти уже  - { new Date().toLocaleTimeString() }</h1>
                </div>
            </div>
        </div>
    );

    ReactDOM.render(
        element,
        document.getElementById('root')
    );
}

setInterval(tick, 1000);

