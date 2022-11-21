import { Audio } from 'expo-av';
import { StatusBar } from "expo-status-bar";
import { Button, StyleSheet, Switch, Text, View, Image } from "react-native";
import React, { useState } from "react";
// import { NativeModules, Button } from "react-native";
// import MyCustomView from './myviews';
import RTNCalculator from '@spacecraft/mycm/src/NativeCalculator';

export default function HomeScreen({ navigation }) {
    const [isChecked, setisChecked] = useState(true);
    const [sound, setSound] = React.useState();

    React.useEffect(() => {
        return sound
            ? () => {
                console.log('Unloading Sound');
                sound.unloadAsync();
            }
            : undefined;
    }, [sound]);

    // const { CalendarModule } = NativeModules;
  // const a = CalendarModule.createCalendarEvent("testName", "testLocation");
  // console.log("cjf We will invoke the native module here!  "+a);



    return (
        <View style={styles.container}>
            <StatusBar style="auto" />
            <Text>Open up App.js to start working on your app!</Text>
            <Button title="open play list" color={isChecked ? "#f5dd4b" : "#f4f3f4"} onPress={async () => {
                navigation.navigate('PlayList')

                // const { sound } = await Audio.Sound.createAsync(require('./assets/a.mp3'), {
                //     onPlaybackStatusUpdate: (status) => {
                //         console.log(status);
                //     }
                // });
                // setSound(sound);
                // await sound.playAsync();

                const value = await RTNCalculator.add(3, 7);
                console.log(value)

            }} />

            <Switch
                value={isChecked}
                onValueChange={() => setisChecked(!isChecked)}
                trackColor={{ false: "#767577", true: "#81b0ff" }}
                thumbColor={isChecked ? "#f5dd4b" : "#f4f3f4"}
                ios_backgroundColor="#3e3e3e"
            />
            <Image
                source={{
                    uri: "https://reactnative.dev/img/tiny_logo.png",
                }}
                style={{ width: 50, height: 50 }}
            />
            {/* <MyCustomView></MyCustomView> */}
        </View>
    );
}
const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: "#fff",
        alignItems: "center",
        justifyContent: "center",
    },
});
