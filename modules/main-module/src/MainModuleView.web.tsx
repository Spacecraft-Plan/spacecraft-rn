import * as React from 'react';

import { MainModuleViewProps } from './MainModule.types';

export default function MainModuleView(props: MainModuleViewProps) {
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
