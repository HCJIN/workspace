import { StatusBar } from 'expo-status-bar';
import React, { useEffect, useState } from 'react';
import { StyleSheet, Text, View, Platform } from 'react-native';
import * as Location from 'expo-location'; // expo-location 모듈 가져오기

export default function App() {

  const [currentLocation, setCurrentLocation] = useState(null);

  useEffect(() => {
    (async () => {
      let { status } = await Location.requestForegroundPermissionsAsync();
      if (status !== 'granted') {
        console.log('Permission to access location was denied');
        return;
      }

      let location = await Location.getCurrentPositionAsync({});
      setCurrentLocation({
        latitude: location.coords.latitude,
        longitude: location.coords.longitude
      });
    })();
  }, []);

  return (
    <View style={styles.container}>
      <Text>위도 경도 받기</Text>
      {
        currentLocation ? (
          <Text style={styles.text}>
            {currentLocation.latitude} / {currentLocation.longitude}
          </Text>
        ) : (
          <Text style={styles.text}>위치 정보를 받지 못했습니다.</Text>
        )
      }
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  text: {
    textAlign: "center",
    fontSize: 20,
    margin: 15,
    color: "black",
    fontWeight: "600",
  },
});

//expo install expo-location