# 🛒 REPO Cart Mod

A Fabric mod for Minecraft 1.21.1 that brings the chaotic shopping experience of [R.E.P.O.](https://store.steampowered.com/app/3241660/REPO/) into your world — starting with a custom price-tagged minecart entity.

---

## Features

- **REPO Cart Entity** — A custom minecart that tracks and displays a live price label above it
- **Dynamic Model** — A gold pile appears on the cart when the price exceeds $100
- **Server → Client Sync** — Price data is tracked and synced automatically using Minecraft's `DataTracker` system
- **Custom Renderer** — Dedicated entity renderer and model layer for the cart

---

## Requirements

| Dependency | Version |
|---|---|
| Minecraft | 1.21.1 |
| Fabric Loader | ≥ 0.16.0 |
| Fabric API | 0.102.0+1.21.1 |
| Fabric Language Kotlin | ≥ 1.12.1 |
| Java | 21 |

---

## Building

Clone the repo and run:

```bash
./gradlew build
```

The output JAR will be in `build/libs/`. To do a clean build:

```bash
./gradlew cleanbuild
```

To force-refresh all dependencies:

```bash
./gradlew buildrefresh
```

---

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.21.1
2. Download [Fabric API](https://modrinth.com/mod/fabric-api) and [Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin)
3. Drop all JARs into your `.minecraft/mods/` folder
4. Launch and enjoy the chaos

---

## Project Structure

```
src/
├── main/kotlin/com/repo/
│   ├── RepoMod.kt               # Mod entry point, entity type registration
│   └── entity/RepoCartEntity.kt # Custom minecart with synced price field
├── client/kotlin/com/repo/client/
│   └── RepoModClient.kt         # Client entry point, renderer registration
└── main/client/kotlin/repo/client/render/
    ├── PriceCartEntityRenderer.kt       # Renders the price label above the cart
    ├── RepoModelLayers.kt               # Defines the custom model layer
    └── model/PriceCartEntityModel.kt    # Custom model with dynamic gold pile
```

---

## How It Works

The `RepoCartEntity` stores a `price` value as tracked data, which Minecraft automatically syncs from server to client. The custom renderer reads this value to draw a floating price tag (`Price: $X`) above the cart. If the price climbs above 100, the model switches to show a gold pile inside the cart.

---

## License

This project is licensed under the [Apache License 2.0](LICENSE).
You're free to use, modify, and distribute this mod, as long as you include proper attribution and a copy of the license.
