# PersoDist
A small paper plugin that allows manipulation of view and simulation distance of individual 
players.

## Usage
You can (**temporarily!**) change the view or simulation distance of a single player using the
`/persodist` (or `/pd`) command.
``` 
/persodist (mode) (type) (player) [distance]
```
### Arguments:
- `mode`: either "get" or "set"
  - "get" will print out the given `type` of distance
  - "set" will set the given `type` of distance
- `type`: either "sim" or "view"
  - "sim" for simulation distance
  - "view" for view or render distance
- `player`: name of the player whose given distance type will be manipulated
  - due to API limitations this player must be online

### Note
Using the command above will only make non-permanent changes. If a player, whose view or 
simulation distance was changed, leaves and rejoins, it will reset to the server default that is 
given in 
`server.properties`.
