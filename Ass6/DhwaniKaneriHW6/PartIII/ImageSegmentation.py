import sys
from sklearn.cluster import MiniBatchKMeans
import urllib
import cv2
import numpy as np
import argparse


def main(args):
    k = args[1]
    path = args[2]

    # url = 'http://www.utdallas.edu/~axn112530/cs6375/unsupervised/images/image5.jpg'
    # url='http://www.utdallas.edu/~axn112530/cs6375/unsupervised/images/image4.jpg'
    # url='http://www.utdallas.edu/~axn112530/cs6375/unsupervised/images/image1.jpg'
    # url='http://www.utdallas.edu/~axn112530/cs6375/unsupervised/images/image3.jpg'
    url = 'http://www.utdallas.edu/~axn112530/cs6375/unsupervised/images/image2.jpg'
    #    url_response = urllib.urlopen(url)
    url_response = urllib.urlopen(path)

    img_array = np.array(bytearray(url_response.read()), dtype=np.uint8)
    img = cv2.imdecode(img_array, -1)
    cv2.imshow("Original Image", img)
    (h, w) = img.shape[:2]
    img = img.reshape((img.shape[0] * img.shape[1], 3))

    # cluster = MiniBatchKMeans(n_clusters=10)
    cluster = MiniBatchKMeans(n_clusters=k)
    labels = cluster.fit_predict(img)
    clustered = cluster.cluster_centers_.astype("uint8")[labels]

    clustered = clustered.reshape((h, w, 3))

    img = img.reshape((h, w, 3))

    cv2.imshow("Clustered Image", clustered)
    cv2.waitKey(0)
    cv2.destroyAllWindows()


main(sys.argv)
