import { NativeModule, requireNativeModule } from 'expo';

import { AccountModuleEvents } from './AccountModule.types';

declare class AccountModule extends NativeModule<AccountModuleEvents> {
  PI: number;
  hello(): string;
  setValueAsync(value: string): Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<AccountModule>('AccountModule');
