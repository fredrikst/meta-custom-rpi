# Description
Custom yocto layer for rpi5 on scarthgap. Only console. Mainly for my own education. Use at your own risk.

# Usage
1. Replace your local.conf with local.conf.copy
2. Add your own wpa_supplicant.conf-sane under recipes-connectivity/wpa-supplican/files
3. Add your own username and password in my-image.bb

# Future improvements
* Replace sysvinit with systemd
* Only allow access with ssh keys
* Some more things
