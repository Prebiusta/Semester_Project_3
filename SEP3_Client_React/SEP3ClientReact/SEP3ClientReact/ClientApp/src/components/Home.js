import React, { Component } from 'react';

export class Home extends Component {
  static displayName = Home.name;

  render () {
    return (
      <div>
        <h1>Fuck Razor!</h1>
        <p>I did GET request for displaying projects, but I made POST requests in ajax which is not amazing so I removed it for now and try to figure out how to call POST function from .NET from React. </p>
      </div>
    );
  }
}
