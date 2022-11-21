import React from 'react';
import MyReactNativeYueRenderer from '@spacecraft/myrenderer/src/myReactNativeYueRenderer';
import App from '@spacecraft/myrenderer/src/App';
import gui from 'gui';

const win = gui.Window.create({});
win.setContentSize({ width: 400, height: 400 });

win.center();
win.activate();

MyReactNativeYueRenderer.render(<App />, win);

if (!process.versions.yode) {
    gui.MessageLoop.run();
    process.exit(0);
}
