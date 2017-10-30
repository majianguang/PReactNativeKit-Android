'use strict';
import React, {Component, PureComponent} from 'react';
import {requireNativeComponent,StyleSheet, Text,View,processColor} from 'react-native';
import PropTypes from 'prop-types';

const MCircle = requireNativeComponent('MCircle', {
  propTypes: {
    color: PropTypes.number,
    radius: PropTypes.number,
    ...View.propTypes // 包含默认的View的属性
  },
});

class Circle extends PureComponent {

  static propTypes = {
    radius: PropTypes.number,
    color: PropTypes.string, // 这里传过来的是string
    ...View.propTypes // 包含默认的View的属性
  }

  render() {
    const { style, radius, color } = this.props;

    return (
      <MCircle color={processColor(color)} radius={radius} style={style} />
    );
  }

}

module.exports = Circle;


