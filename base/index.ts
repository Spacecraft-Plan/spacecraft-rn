// Reexport the native module. On web, it will be resolved to BaseModule.web.ts
// and on native platforms to BaseModule.ts
export { default } from './src/BaseModule';
export { default as BaseView } from './src/BaseView';
export * from  './src/Base.types';
