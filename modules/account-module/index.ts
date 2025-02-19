// Reexport the native module. On web, it will be resolved to AccountModule.web.ts
// and on native platforms to AccountModule.ts
export { default } from './src/AccountModule';
export { default as AccountModuleView } from './src/AccountModuleView';
export * from  './src/AccountModule.types';
