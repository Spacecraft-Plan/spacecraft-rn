import { Canvas, Circle, Group } from "@shopify/react-native-skia";
import { Button, StyleSheet, Switch, Text, View, Image } from "react-native";
export default function SkiaScreen() {
    const size = 256;
    const r = size * 0.33;
    return (
        // <View><Text>asdfsf</Text></View>
        <Canvas style={{ flex: 1 }}>
            <Group blendMode="multiply">
                <Circle cx={r} cy={r} r={r} color="cyan" />
                <Circle cx={size - r} cy={r} r={r} color="magenta" />
                <Circle
                    cx={size / 2}
                    cy={size - r}
                    r={r}
                    color="yellow"
                />
            </Group>
        </Canvas>
    );
}