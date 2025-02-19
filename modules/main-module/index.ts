// Reexport the native module. On web, it will be resolved to MainModule.web.ts
// and on native platforms to MainModule.ts
export { default } from './src/MainModule';
export { default as MainModuleView } from './src/MainModuleView';
export * from  './src/MainModule.types';
