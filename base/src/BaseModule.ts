import { NativeModule, requireNativeModule } from 'expo';

import { BaseModuleEvents } from './Base.types';

declare class BaseModule extends NativeModule<BaseModuleEvents> {
  PI: number;
  hello(): string;
  setValueAsync(value: string): Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<BaseModule>('Base');
