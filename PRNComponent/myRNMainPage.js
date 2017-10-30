'use strict';
 import React, {PureComponent} from 'react';
 import {
   StyleSheet,
   Text,
   View,
   NativeModules,
   ToastAndroid
 } from 'react-native';

 import {
   StackNavigator,
 } from 'react-navigation';

 import MyPage1 from "./myRNPage1";

class MainPage extends PureComponent {

    //RN内页面跳转
     gotoNextPage () {
        const { navigate } = this.props.navigation;
        navigate('MyPage1',{name:'page1'});
     }
    //callback回调RN
    rnCallback () {
        NativeModules.androidNativeModule.rnCallAndroidWithCallback("callback参数", (result) => {
            ToastAndroid.show("Callback收到消息:" + result, ToastAndroid.SHORT)
        });
    }
    //Promis回调RN
    rnPromise () {
            NativeModules.androidNativeModule.rnCallAndroidWithPromise("promis参数").then(
                (result) => {
                    ToastAndroid.show("Promise收到消息:" + result, ToastAndroid.SHORT)
                }

            ).catch((error) => {
                    ToastAndroid.show("Promise收到消息Error" + error)
            });
         }
     //RN调用原生，不需要回调
    rnNormalSkip() {
        NativeModules.androidNativeModule.rnNormalCallAndroid("普通回调参数");
    }

    render() {
        return (
            <View style={styles.container}>
                  <Text style={styles.hello}>Hello, 我是RN主页面</Text>
                  <Text style={styles.btn} onPress={this.gotoNextPage.bind(this)}>点我跳到下一个RN页面</Text>
                  <Text style={styles.btn} onPress={this.rnCallback.bind(this)}>callback通信</Text>
                  <Text style={styles.btn} onPress={this.rnPromise.bind(this)}>Promise通信</Text>
                  <Text style={styles.btn} onPress={this.rnNormalSkip.bind(this)}>普通通信，不需要回调</Text>
             </View>
        )
   }
 };

const APP = StackNavigator({
     Main:{
         screen:MainPage,
         navigationOptions: {
             title:"主页",
             style: {
                 backgroundColor:'#fff'
             },
             backTitle:null
         }
     },
     MyPage1:{
        screen:MyPage1,
        navigationOptions: {
                     title:"RN页面1",
                     style: {
                         backgroundColor:'#fff'
                     },
                     backTitle:null
        }
     }
 });

 module.exports = APP;

 var styles = StyleSheet.create({
   container: {
     flex: 1,
   },
   hello: {
     fontSize: 20,
     textAlign: 'center',
     margin: 10,
   },
   btn: {
    fontSize:22,
    textAlign:'center',
    backgroundColor:'red',
    margin: 10,
   }
 });

