import * as React from 'react';

import { BaseViewProps } from './Base.types';

export default function BaseView(props: BaseViewProps) {
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
