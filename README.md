# 高效开发、高质量交付

## 1.代码设计(code design)

[CODEDESIGN](https://big-frontend.github.io/spacecraft-android/docs/CODEDESIGN.md)

## 2.开发(coding)

- mock平台:mitmproxy
- 清晰的分包结构与代码高可复用：util、widget

## 3.代码评审(code review)

### 质量扫描 、安全扫描(源代码、第三方组件) 、开源合规

- 质量扫描
    - 代码静态分析
    - Android Style
    - Kotlin Style
  
- 安全扫描
    - 风险代码 

### 测试

- 覆盖率测试：[Android增量代码测试覆盖率工具](https://tech.meituan.com/2017/06/16/android-jacoco-practace.html)、JaCoCo
- 自动化测试：单元测试、集成测试等，[自动化测试在美团外卖的实践与落地](https://tech.meituan.com/2022/09/15/automated-testing-in-meituan.html)

## 4.部署 & 渠道

- [蒲公英分发](https://www.pgyer.com/manager/dashboard/app/747e76f865ef67134972fc6e54b7edbd)
- [firebase app distribution](https://console.firebase.google.com/project/spacecraft-22dc1/appdistribution/app/android:com.electrolytej.pisces/releases?hl=zh-cn)

## 5.性能与稳定性监控
