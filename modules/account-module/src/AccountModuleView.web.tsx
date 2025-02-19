import * as React from 'react';

import { AccountModuleViewProps } from './AccountModule.types';

export default function AccountModuleView(props: AccountModuleViewProps) {
  return (
    <div>
      <iframe
        style={{ flex: 1 }}
        src={props.url}
        onLoad={() => props.onLoad({ nativeEvent: { url: props.url } })}
      />
    </div>
  );
}
