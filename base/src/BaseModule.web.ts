import { registerWebModule, NativeModule } from 'expo';

import { ChangeEventPayload } from './Base.types';

type BaseModuleEvents = {
  onChange: (params: ChangeEventPayload) => void;
}

class BaseModule extends NativeModule<BaseModuleEvents> {
  PI = Math.PI;
  async setValueAsync(value: string): Promise<void> {
    this.emit('onChange', { value });
  }
  hello() {
    return 'Hello world! 👋';
  }
};

export default registerWebModule(BaseModule);
