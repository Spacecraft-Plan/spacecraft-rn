import { NativeModule, requireNativeModule } from 'expo';

import { MainModuleEvents } from './MainModule.types';

declare class MainModule extends NativeModule<MainModuleEvents> {
  PI: number;
  hello(): string;
  setValueAsync(value: string): Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<MainModule>('MainModule');
