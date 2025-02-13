import { TurboModuleRegistry,TurboModule } from "react-native";

export interface Spec extends TurboModule {
  add(a: number, b: number): Promise<number>;
}

export default TurboModuleRegistry.get<Spec>("Calculator") as Spec | null;
