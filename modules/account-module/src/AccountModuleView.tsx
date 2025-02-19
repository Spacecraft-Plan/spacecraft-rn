import { requireNativeView } from 'expo';
import * as React from 'react';

import { AccountModuleViewProps } from './AccountModule.types';

const NativeView: React.ComponentType<AccountModuleViewProps> =
  requireNativeView('AccountModule');

export default function AccountModuleView(props: AccountModuleViewProps) {
  return <NativeView {...props} />;
}
