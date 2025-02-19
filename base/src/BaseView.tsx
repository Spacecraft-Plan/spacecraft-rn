import { requireNativeView } from 'expo';
import * as React from 'react';

import { BaseViewProps } from './Base.types';

const NativeView: React.ComponentType<BaseViewProps> =
  requireNativeView('Base');

export default function BaseView(props: BaseViewProps) {
  return <NativeView {...props} />;
}
