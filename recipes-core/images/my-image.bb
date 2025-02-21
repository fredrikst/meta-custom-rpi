require recipes-core/images/core-image-base.bb
inherit extrausers

DESCRIPTION = "Custom image with sudo user, ssh and wifi for rpi5"

IMAGE_FEATURES += "ssh-server-dropbear"

IMAGE_INSTALL:append = " sudo net-tools"
IMAGE_INSTALL:append = " iw linux-firmware-rpidistro-bcm43456 wpa-supplicant kernel-modules busybox-udhcpd"

PASSWD = "<your password>"

EXTRA_USERS_PARAMS:append = "\
    groupadd netdev; \
    useradd -u 1200 -d /home/<your user> -s /bin/sh -p '${PASSWD}' <your user>; \
    usermod -a -G sudo <your user>; \
    "

EXTRA_USERS_PARAMS:append = " usermod -L -e 1 root; "

update_sudoers(){
    sed -i 's/# %sudo/%sudo/' ${IMAGE_ROOTFS}/etc/sudoers
}

ROOTFS_POSTPROCESS_COMMAND += "update_sudoers;"
