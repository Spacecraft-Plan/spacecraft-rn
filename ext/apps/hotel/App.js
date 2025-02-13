
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import HomeScreen from './pages/home';
import PlayListScreen from './pages/playlist';
import SkiaScreen from './pages/skia';
const Stack = createNativeStackNavigator();
export default function App() {

  return (
     <NavigationContainer>
      <Stack.Navigator initialRouteName="Skia">
        <Stack.Screen name="Home" component={HomeScreen} />
        <Stack.Screen name="PlayList" component={PlayListScreen} />
        <Stack.Screen name="Skia" component={SkiaScreen} />
      </Stack.Navigator>
      </NavigationContainer>
  );
}


