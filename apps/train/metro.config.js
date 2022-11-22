// Learn more https://docs.expo.io/guides/customizing-metro
const { getDefaultConfig } = require('expo/metro-config');

// module.exports = getDefaultConfig(__dirname);

const fs = require('fs');
const pathSep = require('path').sep;

function manifest(path) {
  if (path.length) {
    const manifestFile = `./dist/common_manifest_${process.env.PLATFORM}.txt`;
    if (!fs.existsSync(manifestFile)) {
      fs.writeFileSync(manifestFile, path);
    } else {
      fs.appendFileSync(manifestFile, '\n' + path);
    }
  }
}

function processModuleFilter(module) {
  if (module['path'].indexOf('__prelude__') >= 0) {
    return false;
  }
  manifest(module['path']);
  console.log(module)
  return true;
}

function createModuleIdFactory() {
  return path => {
    // console.log('cjf', path, __dirname)
    let name = '';
    if (path.startsWith(__dirname)) {
      name = path.substr(__dirname.length + 1);
    }
    let regExp = pathSep == '\\' ?
      new RegExp('\\\\', "gm") :
      new RegExp(pathSep, "gm");
    // console.log('cjf', name.replace(regExp, '_'))
    return name.replace(regExp, '_');
  }
}
module.exports = {
    /* general options */

    resolver: {
        /* resolver options:解析模块以图表示 */
    },
    transformer: {
        /* transformer options:模块转成目标平台的码 */
    },
    serializer: {
        /* serializer options：序列化多个模块成一个或者多个bundle */
        createModuleIdFactory, processModuleFilter
    },
    server: {
        /* server options */
    },
    watcher: {
        /* watcher options */
        watchman: {
            /* Watchman-specific options */
        }
    }
};
