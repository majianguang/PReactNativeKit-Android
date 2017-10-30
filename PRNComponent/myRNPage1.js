'use strict';
 import React, {PureComponent} from 'react';
 import {
   StyleSheet,
   Text,
   View
 } from 'react-native';

 var CircleView = require('./PRNNativeCircleView');

 export default class WebViewPage extends PureComponent {
   render() {
     return (
       <View style={styles.container}>
            <CircleView color="#25c5f7" radius={50} style={styles.circle} />
       </View>
     )
   }
 }
 var styles = StyleSheet.create({
   container: {
     flex: 1,
     justifyContent: 'center',
   },
   circle: {
    backgroundColor:'red',
    width:200,
    height:200
   }
 });