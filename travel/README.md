# Tourism_Management_System（旅游管理系统）

## 项目简介

本项目是一个基于 **Spring Boot + MyBatis-Plus + Vue.js + MySQL** 构建的旅游综合管理平台，包含后端 API 服务、管理员前端（admin）和用户前端（front）三部分。

主要功能模块：
- 景点信息管理（热门景点、线路信息）
- 酒店信息与房间预订
- 餐厅信息与预订
- 报团管理（导游、行程）
- 门票订单管理
- 用户管理与权限控制（Shiro）
- 新闻资讯、论坛互动

---

## 技术栈

| 层次       | 技术                                    |
|------------|----------------------------------------|
| 后端框架   | Spring Boot 2.2.2                      |
| 持久层     | MyBatis-Plus 2.3                       |
| 数据库     | MySQL 5.7+                             |
| 安全认证   | Apache Shiro 1.3.2                     |
| 前端框架   | Vue 2 + Element UI + Vue Router + Vuex |
| 构建工具   | Maven 3 / npm (cnpm)                   |

---

## 环境要求

- **JDK 1.8**（Java 8）
- **Maven 3.x**
- **MySQL 5.7+**
- **Node.js 12+** 及 **npm / cnpm**（仅在需要二次开发前端时）

---

## 快速启动

### 第一步：导入数据库

1. 启动 MySQL，确保 root 用户密码为 `123456`（若不同请修改配置）。
2. 执行根目录下的 `travel.sql` 文件，该脚本会自动创建 `travel` 数据库并初始化数据：

```bash
mysql -u root -p < travel.sql
```

或在 MySQL 客户端（如 Navicat / DBeaver）中直接运行 `travel.sql`。

### 第二步：配置数据库连接（可选）

默认配置位于 `travel/src/main/resources/application.yml`：

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/travel?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: root
    password: 123456
```

> ⚠️ `useSSL=false` 适用于**本地开发环境**。若部署到生产服务器，建议将其改为 `useSSL=true` 并配置相应证书，以加密数据库连接。

如需修改数据库地址、用户名或密码，请编辑此文件。

### 第三步：启动后端

在 `travel/` 目录下执行：

```bash
cd travel
mvn spring-boot:run
```

> 也可以在 IntelliJ IDEA 中打开 `travel/` 目录（作为 Maven 项目），然后直接运行 `SpringbootSchemaApplication` 主类。

后端启动成功后，服务监听：`http://localhost:8080/travel`

### 第四步：访问系统

后端启动后，内置的静态前端资源（已构建完成）即可直接访问：

| 页面           | 地址                                                          |
|----------------|---------------------------------------------------------------|
| **管理员后台** | http://localhost:8080/travel/admin/dist/index.html            |
| **用户前台**   | http://localhost:8080/travel/front/dist/index.html            |

> 后端启动时会在 Windows 上自动弹出浏览器打开上述两个页面。在 Linux/macOS 上请手动复制链接到浏览器访问。

---

## 使用 IntelliJ IDEA 打开项目

1. 打开 IntelliJ IDEA，选择 **File → Open**。
2. 选择仓库中的 **`travel`** 目录（包含 `pom.xml` 的那一层）。
3. IDEA 会自动识别为 Maven 项目并下载依赖。
4. 依赖下载完成后，找到 `com.SpringbootSchemaApplication`，右键 → **Run**。

---

## 前端二次开发（可选）

如需修改前端源码，分别进入对应目录操作：

### 管理员前端（admin）

```bash
cd travel/src/main/resources/admin/admin

# 安装依赖（推荐使用 cnpm 加速）
cnpm install
# 或
npm install

# 启动开发服务器（端口 8081，自动代理后端 8080）
npm run serve

# 构建生产包（输出到 dist/，后端会直接使用）
npm run build
```

Windows 可直接双击目录下的批处理脚本：
- `1-install.bat` — 安装依赖
- `2-run.bat` — 启动开发服务器
- `3-build.bat` — 构建生产包

### 用户前台（front）

```bash
cd travel/src/main/resources/front/front

cnpm install
npm run serve   # 开发模式
npm run build   # 构建生产包
```

Windows 批处理脚本：`install.bat` / `run.bat` / `build.bat`

---

## 目录结构

```
Tourism_Management_System/
├── travel.sql                          # 数据库初始化脚本
└── travel/                             # Spring Boot 后端 + 前端资源
    ├── pom.xml                         # Maven 项目配置
    └── src/main/
        ├── java/com/
        │   ├── SpringbootSchemaApplication.java   # 启动类
        │   ├── controller/             # REST 控制器
        │   ├── service/                # 业务逻辑层
        │   ├── dao/                    # MyBatis-Plus Mapper
        │   ├── entity/                 # 实体类
        │   └── config/                 # 配置类（Shiro、拦截器等）
        └── resources/
            ├── application.yml         # 应用配置
            ├── mapper/                 # MyBatis XML 映射文件
            ├── admin/admin/            # 管理员前端 Vue 项目
            └── front/front/            # 用户前台 Vue 项目
```

---

## 常见问题

**Q: 启动报数据库连接错误？**  
A: 检查 MySQL 是否启动，并确认 `application.yml` 中的用户名密码正确，且已执行 `travel.sql` 导入数据库。

**Q: 端口 8080 被占用？**  
A: 修改 `application.yml` 中的 `server.port`，同时修改前端 `vue.config.js` 中 proxy 的目标地址。

**Q: 前端页面空白或报 404？**  
A: 确保后端已正常启动，访问路径为 `http://localhost:8080/travel/admin/dist/index.html`（注意需加 `/dist/index.html`）。

**Q: Windows 上 cnpm 不可用？**  
A: 先安装：`npm install -g cnpm --registry=https://registry.npmmirror.com`，或直接使用 `npm install` 替代。