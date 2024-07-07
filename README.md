# Acid Rain Mod

## Description
Makes so it rains every 7 days (changeable in config file), that is, it will start raining if it isn't already, and the rain will cause poison effect to any player is under it

### Features:
- Periodic acid rain events (default: every 7 days, configurable)
- Poison effect applied to players exposed to the rain
- If and only if it is raining acid, checks regularly (every 15 seconds) if the rain has naturally stopped to stop giving the poison

## How It Works
The mod triggers a rain event at configurable intervals. When is raining and the day is a multiple of 7 in this case, sends a message warning all players about the acid rain, and gives them poison effect if they're under it.

The mod continuously monitors the world tick if the acid is active. Every 15 seconds, it checks if the acid rain has stopped naturally, and if so, stops giving player the poision effect.

## Customization
To adjust the frequency of every so many days it will rain acid, change the timer variable in config file to the total number of ticks necessarry. Note that a game day is 24000 ticks, so multiply the days by it if you choose so.

## License
This project is released under GPLv3. You are free to copy, modify, and redistribute this mod as permitted by the license terms. Please ensure you provide appropriate credit adapting it.

## Development
**Made with MCreator**

---
