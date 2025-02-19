import { requireNativeView } from 'expo';
import * as React from 'react';

import { MainModuleViewProps } from './MainModule.types';

const NativeView: React.ComponentType<MainModuleViewProps> =
  requireNativeView('MainModule');

export default function MainModuleView(props: MainModuleViewProps) {
  return <NativeView {...props} />;
}
