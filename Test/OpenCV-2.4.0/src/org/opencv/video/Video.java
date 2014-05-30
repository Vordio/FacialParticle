
//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.video;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;
import org.opencv.core.TermCriteria;

public class Video {

    public static final int
            OPTFLOW_USE_INITIAL_FLOW = 4,
            OPTFLOW_FARNEBACK_GAUSSIAN = 256;


    //
    // C++:  RotatedRect CamShift(Mat probImage, Rect& window, TermCriteria criteria)
    //

/**
 * <p>Finds an object center, size, and orientation.</p>
 *
 * <p>The function implements the CAMSHIFT object tracking algorithm [Bradski98].
 * First, it finds an object center using "meanShift" and then adjusts the
 * window size and finds the optimal rotation. The function returns the rotated
 * rectangle structure that includes the object position, size, and orientation.
 * The next position of the search window can be obtained with <code>RotatedRect.boundingRect()</code>.</p>
 *
 * <p>See the OpenCV sample <code>camshiftdemo.c</code> that tracks colored
 * objects.</p>
 *
 * @param probImage Back projection of the object histogram. See
 * "calcBackProject".
 * @param window Initial search window.
 * @param criteria Stop criteria for the underlying "meanShift".
 *
 * <p>:returns: (in old interfaces) Number of iterations CAMSHIFT took to converge</p>
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#camshift">org.opencv.video.Video.CamShift</a>
 */
    public static RotatedRect CamShift(Mat probImage, Rect window, TermCriteria criteria)
    {
        double[] window_out = new double[4];
        RotatedRect retVal = new RotatedRect(CamShift_0(probImage.nativeObj, window.x, window.y, window.width, window.height, window_out, criteria.type, criteria.maxCount, criteria.epsilon));
        if(window!=null){ window.x = (int)window_out[0]; window.y = (int)window_out[1]; window.width = (int)window_out[2]; window.height = (int)window_out[3]; }
        return retVal;
    }


    //
    // C++:  double calcGlobalOrientation(Mat orientation, Mat mask, Mat mhi, double timestamp, double duration)
    //

/**
 * <p>Calculates a global motion orientation in a selected region.</p>
 *
 * <p>The function calculates an average motion direction in the selected region
 * and returns the angle between 0 degrees and 360 degrees. The average
 * direction is computed from the weighted orientation histogram, where a recent
 * motion has a larger weight and the motion occurred in the past has a smaller
 * weight, as recorded in <code>mhi</code>.</p>
 *
 * @param orientation Motion gradient orientation image calculated by the
 * function "calcMotionGradient".
 * @param mask Mask image. It may be a conjunction of a valid gradient mask,
 * also calculated by "calcMotionGradient", and the mask of a region whose
 * direction needs to be calculated.
 * @param mhi Motion history image calculated by "updateMotionHistory".
 * @param timestamp Timestamp passed to "updateMotionHistory".
 * @param duration Maximum duration of a motion track in milliseconds, passed to
 * "updateMotionHistory".
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#calcglobalorientation">org.opencv.video.Video.calcGlobalOrientation</a>
 */
    public static double calcGlobalOrientation(Mat orientation, Mat mask, Mat mhi, double timestamp, double duration)
    {

        double retVal = calcGlobalOrientation_0(orientation.nativeObj, mask.nativeObj, mhi.nativeObj, timestamp, duration);

        return retVal;
    }


    //
    // C++:  void calcMotionGradient(Mat mhi, Mat& mask, Mat& orientation, double delta1, double delta2, int apertureSize = 3)
    //

/**
 * <p>Calculates a gradient orientation of a motion history image.</p>
 *
 * <p>The function calculates a gradient orientation at each pixel <em>(x, y)</em>
 * as:</p>
 *
 * <p><em>orientation(x,y)= arctan((dmhi/dy)/(dmhi/dx))</em></p>
 *
 * <p>In fact, "fastAtan2" and "phase" are used so that the computed angle is
 * measured in degrees and covers the full range 0..360. Also, the
 * <code>mask</code> is filled to indicate pixels where the computed angle is
 * valid.</p>
 *
 * @param mhi Motion history single-channel floating-point image.
 * @param mask Output mask image that has the type <code>CV_8UC1</code> and the
 * same size as <code>mhi</code>. Its non-zero elements mark pixels where the
 * motion gradient data is correct.
 * @param orientation Output motion gradient orientation image that has the same
 * type and the same size as <code>mhi</code>. Each pixel of the image is a
 * motion orientation, from 0 to 360 degrees.
 * @param delta1 Minimal (or maximal) allowed difference between
 * <code>mhi</code> values within a pixel neighborhood.
 * @param delta2 Maximal (or minimal) allowed difference between
 * <code>mhi</code> values within a pixel neighborhood. That is, the function
 * finds the minimum (<em>m(x,y)</em>) and maximum (<em>M(x,y)</em>)
 * <code>mhi</code> values over <em>3 x 3</em> neighborhood of each pixel and
 * marks the motion orientation at <em>(x, y)</em> as valid only if
 *
 * <p><em>min(delta1, delta2) <= M(x,y)-m(x,y) <= max(delta1, delta2).</em></p>
 * @param apertureSize Aperture size of the "Sobel" operator.
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#calcmotiongradient">org.opencv.video.Video.calcMotionGradient</a>
 */
    public static void calcMotionGradient(Mat mhi, Mat mask, Mat orientation, double delta1, double delta2, int apertureSize)
    {

        calcMotionGradient_0(mhi.nativeObj, mask.nativeObj, orientation.nativeObj, delta1, delta2, apertureSize);

        return;
    }

/**
 * <p>Calculates a gradient orientation of a motion history image.</p>
 *
 * <p>The function calculates a gradient orientation at each pixel <em>(x, y)</em>
 * as:</p>
 *
 * <p><em>orientation(x,y)= arctan((dmhi/dy)/(dmhi/dx))</em></p>
 *
 * <p>In fact, "fastAtan2" and "phase" are used so that the computed angle is
 * measured in degrees and covers the full range 0..360. Also, the
 * <code>mask</code> is filled to indicate pixels where the computed angle is
 * valid.</p>
 *
 * @param mhi Motion history single-channel floating-point image.
 * @param mask Output mask image that has the type <code>CV_8UC1</code> and the
 * same size as <code>mhi</code>. Its non-zero elements mark pixels where the
 * motion gradient data is correct.
 * @param orientation Output motion gradient orientation image that has the same
 * type and the same size as <code>mhi</code>. Each pixel of the image is a
 * motion orientation, from 0 to 360 degrees.
 * @param delta1 Minimal (or maximal) allowed difference between
 * <code>mhi</code> values within a pixel neighborhood.
 * @param delta2 Maximal (or minimal) allowed difference between
 * <code>mhi</code> values within a pixel neighborhood. That is, the function
 * finds the minimum (<em>m(x,y)</em>) and maximum (<em>M(x,y)</em>)
 * <code>mhi</code> values over <em>3 x 3</em> neighborhood of each pixel and
 * marks the motion orientation at <em>(x, y)</em> as valid only if
 *
 * <p><em>min(delta1, delta2) <= M(x,y)-m(x,y) <= max(delta1, delta2).</em></p>
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#calcmotiongradient">org.opencv.video.Video.calcMotionGradient</a>
 */
    public static void calcMotionGradient(Mat mhi, Mat mask, Mat orientation, double delta1, double delta2)
    {

        calcMotionGradient_1(mhi.nativeObj, mask.nativeObj, orientation.nativeObj, delta1, delta2);

        return;
    }


    //
    // C++:  void calcOpticalFlowFarneback(Mat prev, Mat next, Mat& flow, double pyr_scale, int levels, int winsize, int iterations, int poly_n, double poly_sigma, int flags)
    //

/**
 * <p>Computes a dense optical flow using the Gunnar Farneback's algorithm.</p>
 *
 * <p>The function finds an optical flow for each <code>prevImg</code> pixel using
 * the [Farneback2003] algorithm so that</p>
 *
 * <p><em>prevImg(y,x) ~ nextImg(y + flow(y,x)[1], x + flow(y,x)[0])</em></p>
 *
 * @param prev a prev
 * @param next a next
 * @param flow Computed flow image that has the same size as <code>prevImg</code>
 * and type <code>CV_32FC2</code>.
 * @param pyr_scale a pyr_scale
 * @param levels Number of pyramid layers including the initial image.
 * <code>levels=1</code> means that no extra layers are created and only the
 * original images are used.
 * @param winsize Averaging window size. Larger values increase the algorithm
 * robustness to image noise and give more chances for fast motion detection,
 * but yield more blurred motion field.
 * @param iterations Number of iterations the algorithm does at each pyramid
 * level.
 * @param poly_n a poly_n
 * @param poly_sigma a poly_sigma
 * @param flags Operation flags that can be a combination of the following:
 * <ul>
 *   <li> OPTFLOW_USE_INITIAL_FLOW Use the input <code>flow</code> as an initial
 * flow approximation.
 *   <li> OPTFLOW_FARNEBACK_GAUSSIAN Use the Gaussian <em>winsizexwinsize</em>
 * filter instead of a box filter of the same size for optical flow estimation.
 * Usually, this option gives z more accurate flow than with a box filter, at
 * the cost of lower speed. Normally, <code>winsize</code> for a Gaussian window
 * should be set to a larger value to achieve the same level of robustness.
 * </ul>
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#calcopticalflowfarneback">org.opencv.video.Video.calcOpticalFlowFarneback</a>
 */
    public static void calcOpticalFlowFarneback(Mat prev, Mat next, Mat flow, double pyr_scale, int levels, int winsize, int iterations, int poly_n, double poly_sigma, int flags)
    {

        calcOpticalFlowFarneback_0(prev.nativeObj, next.nativeObj, flow.nativeObj, pyr_scale, levels, winsize, iterations, poly_n, poly_sigma, flags);

        return;
    }


    //
    // C++:  void calcOpticalFlowPyrLK(Mat prevImg, Mat nextImg, vector_Point2f prevPts, vector_Point2f& nextPts, vector_uchar& status, vector_float& err, Size winSize = Size(21,21), int maxLevel = 3, TermCriteria criteria = TermCriteria( TermCriteria::COUNT+TermCriteria::EPS, 30, 0.01), int flags = 0, double minEigThreshold = 1e-4)
    //

/**
 * <p>Calculates an optical flow for a sparse feature set using the iterative
 * Lucas-Kanade method with pyramids.</p>
 *
 * <p>The function implements a sparse iterative version of the Lucas-Kanade
 * optical flow in pyramids. See [Bouguet00]. The function is parallelized with
 * the TBB library.</p>
 *
 * @param prevImg First 8-bit single-channel or 3-channel input image.
 * @param nextImg Second input image of the same size and the same type as
 * <code>prevImg</code>.
 * @param prevPts Vector of 2D points for which the flow needs to be found. The
 * point coordinates must be single-precision floating-point numbers.
 * @param nextPts Output vector of 2D points (with single-precision
 * floating-point coordinates) containing the calculated new positions of input
 * features in the second image. When <code>OPTFLOW_USE_INITIAL_FLOW</code> flag
 * is passed, the vector must have the same size as in the input.
 * @param status Output status vector. Each element of the vector is set to 1 if
 * the flow for the corresponding features has been found. Otherwise, it is set
 * to 0.
 * @param err Output vector of errors. Each element of the vector is set to a
 * error for the corresponding feature. A type of the error measure can be set
 * in <code>flags</code> parameter. If the flow wasn't found then the error is
 * not defined (use the <code>status</code> parameter to find such cases).
 * @param winSize Size of the search window at each pyramid level.
 * @param maxLevel 0-based maximal pyramid level number. If set to 0, pyramids
 * are not used (single level). If set to 1, two levels are used, and so on.
 * @param criteria Parameter specifying the termination criteria of the
 * iterative search algorithm (after the specified maximum number of iterations
 * <code>criteria.maxCount</code> or when the search window moves by less than
 * <code>criteria.epsilon</code>.
 * @param flags Operation flags:
 * <ul>
 *   <li> OPTFLOW_USE_INITIAL_FLOW Use initial estimations stored in
 * <code>nextPts</code>. If the flag is not set, then <code>prevPts</code> is
 * copied to <code>nextPts</code> and is considered as the initial estimate.
 *   <li> OPTFLOW_LK_GET_MIN_EIGENVALS Use minimum eigen values as a error
 * measure (see <code>minEigThreshold</code> description). If the flag is not
 * set, then L1 distance between patches around the original and a moved point
 * divided by number of pixels in a window is used as a error measure.
 * </ul>
 * @param minEigThreshold The algorithm computes a minimum eigen value of a 2x2
 * normal matrix of optical flow equations (this matrix is called a spatial
 * gradient matrix in [Bouguet00]) divided by number of pixels in a window. If
 * this value is less then <code>minEigThreshold</code> then a corresponding
 * feature is filtered out and its flow is not computed. So it allows to remove
 * bad points earlier and speed up the computation.
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#calcopticalflowpyrlk">org.opencv.video.Video.calcOpticalFlowPyrLK</a>
 */
    public static void calcOpticalFlowPyrLK(Mat prevImg, Mat nextImg, MatOfPoint2f prevPts, MatOfPoint2f nextPts, MatOfByte status, MatOfFloat err, Size winSize, int maxLevel, TermCriteria criteria, int flags, double minEigThreshold)
    {
        Mat prevPts_mat = prevPts;
        Mat nextPts_mat = nextPts;
        Mat status_mat = status;
        Mat err_mat = err;
        calcOpticalFlowPyrLK_0(prevImg.nativeObj, nextImg.nativeObj, prevPts_mat.nativeObj, nextPts_mat.nativeObj, status_mat.nativeObj, err_mat.nativeObj, winSize.width, winSize.height, maxLevel, criteria.type, criteria.maxCount, criteria.epsilon, flags, minEigThreshold);

        return;
    }

/**
 * <p>Calculates an optical flow for a sparse feature set using the iterative
 * Lucas-Kanade method with pyramids.</p>
 *
 * <p>The function implements a sparse iterative version of the Lucas-Kanade
 * optical flow in pyramids. See [Bouguet00]. The function is parallelized with
 * the TBB library.</p>
 *
 * @param prevImg First 8-bit single-channel or 3-channel input image.
 * @param nextImg Second input image of the same size and the same type as
 * <code>prevImg</code>.
 * @param prevPts Vector of 2D points for which the flow needs to be found. The
 * point coordinates must be single-precision floating-point numbers.
 * @param nextPts Output vector of 2D points (with single-precision
 * floating-point coordinates) containing the calculated new positions of input
 * features in the second image. When <code>OPTFLOW_USE_INITIAL_FLOW</code> flag
 * is passed, the vector must have the same size as in the input.
 * @param status Output status vector. Each element of the vector is set to 1 if
 * the flow for the corresponding features has been found. Otherwise, it is set
 * to 0.
 * @param err Output vector of errors. Each element of the vector is set to a
 * error for the corresponding feature. A type of the error measure can be set
 * in <code>flags</code> parameter. If the flow wasn't found then the error is
 * not defined (use the <code>status</code> parameter to find such cases).
 * @param winSize Size of the search window at each pyramid level.
 * @param maxLevel 0-based maximal pyramid level number. If set to 0, pyramids
 * are not used (single level). If set to 1, two levels are used, and so on.
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#calcopticalflowpyrlk">org.opencv.video.Video.calcOpticalFlowPyrLK</a>
 */
    public static void calcOpticalFlowPyrLK(Mat prevImg, Mat nextImg, MatOfPoint2f prevPts, MatOfPoint2f nextPts, MatOfByte status, MatOfFloat err, Size winSize, int maxLevel)
    {
        Mat prevPts_mat = prevPts;
        Mat nextPts_mat = nextPts;
        Mat status_mat = status;
        Mat err_mat = err;
        calcOpticalFlowPyrLK_1(prevImg.nativeObj, nextImg.nativeObj, prevPts_mat.nativeObj, nextPts_mat.nativeObj, status_mat.nativeObj, err_mat.nativeObj, winSize.width, winSize.height, maxLevel);

        return;
    }

/**
 * <p>Calculates an optical flow for a sparse feature set using the iterative
 * Lucas-Kanade method with pyramids.</p>
 *
 * <p>The function implements a sparse iterative version of the Lucas-Kanade
 * optical flow in pyramids. See [Bouguet00]. The function is parallelized with
 * the TBB library.</p>
 *
 * @param prevImg First 8-bit single-channel or 3-channel input image.
 * @param nextImg Second input image of the same size and the same type as
 * <code>prevImg</code>.
 * @param prevPts Vector of 2D points for which the flow needs to be found. The
 * point coordinates must be single-precision floating-point numbers.
 * @param nextPts Output vector of 2D points (with single-precision
 * floating-point coordinates) containing the calculated new positions of input
 * features in the second image. When <code>OPTFLOW_USE_INITIAL_FLOW</code> flag
 * is passed, the vector must have the same size as in the input.
 * @param status Output status vector. Each element of the vector is set to 1 if
 * the flow for the corresponding features has been found. Otherwise, it is set
 * to 0.
 * @param err Output vector of errors. Each element of the vector is set to a
 * error for the corresponding feature. A type of the error measure can be set
 * in <code>flags</code> parameter. If the flow wasn't found then the error is
 * not defined (use the <code>status</code> parameter to find such cases).
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#calcopticalflowpyrlk">org.opencv.video.Video.calcOpticalFlowPyrLK</a>
 */
    public static void calcOpticalFlowPyrLK(Mat prevImg, Mat nextImg, MatOfPoint2f prevPts, MatOfPoint2f nextPts, MatOfByte status, MatOfFloat err)
    {
        Mat prevPts_mat = prevPts;
        Mat nextPts_mat = nextPts;
        Mat status_mat = status;
        Mat err_mat = err;
        calcOpticalFlowPyrLK_2(prevImg.nativeObj, nextImg.nativeObj, prevPts_mat.nativeObj, nextPts_mat.nativeObj, status_mat.nativeObj, err_mat.nativeObj);

        return;
    }


    //
    // C++:  Mat estimateRigidTransform(Mat src, Mat dst, bool fullAffine)
    //

/**
 * <p>Computes an optimal affine transformation between two 2D point sets.</p>
 *
 * <p>The function finds an optimal affine transform *[A|b]* (a <code>2 x 3</code>
 * floating-point matrix) that approximates best the affine transformation
 * between:</p>
 * <ul>
 *   <li> Two point sets
 *   <li> Two raster images. In this case, the function first finds some
 * features in the <code>src</code> image and finds the corresponding features
 * in <code>dst</code> image. After that, the problem is reduced to the first
 * case.
 * </ul>
 *
 * <p>In case of point sets, the problem is formulated as follows: you need to find
 * a 2x2 matrix *A* and 2x1 vector *b* so that:</p>
 *
 * <p><em>[A^*|b^*] = arg min _([A|b]) sum _i|dst[i] - A (src[i])^T - b| ^2</em></p>
 *
 * <p>where <code>src[i]</code> and <code>dst[i]</code> are the i-th points in
 * <code>src</code> and <code>dst</code>, respectively</p>
 *
 * <p><em>[A|b]</em> can be either arbitrary (when <code>fullAffine=true</code>) or
 * have a form of</p>
 *
 * <p><em>a_11 a_12 b_1
 * -a_12 a_11 b_2 </em></p>
 *
 * <p>when <code>fullAffine=false</code>.</p>
 *
 * @param src First input 2D point set stored in <code>std.vector</code> or
 * <code>Mat</code>, or an image stored in <code>Mat</code>.
 * @param dst Second input 2D point set of the same size and the same type as
 * <code>A</code>, or another image.
 * @param fullAffine If true, the function finds an optimal affine
 * transformation with no additional restrictions (6 degrees of freedom).
 * Otherwise, the class of transformations to choose from is limited to
 * combinations of translation, rotation, and uniform scaling (5 degrees of
 * freedom).
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#estimaterigidtransform">org.opencv.video.Video.estimateRigidTransform</a>
 * @see org.opencv.calib3d.Calib3d#findHomography
 * @see org.opencv.imgproc.Imgproc#getAffineTransform
 * @see org.opencv.imgproc.Imgproc#getPerspectiveTransform
 */
    public static Mat estimateRigidTransform(Mat src, Mat dst, boolean fullAffine)
    {

        Mat retVal = new Mat(estimateRigidTransform_0(src.nativeObj, dst.nativeObj, fullAffine));

        return retVal;
    }


    //
    // C++:  int meanShift(Mat probImage, Rect& window, TermCriteria criteria)
    //

/**
 * <p>Finds an object on a back projection image.</p>
 *
 * <p>The function implements the iterative object search algorithm. It takes the
 * input back projection of an object and the initial position. The mass center
 * in <code>window</code> of the back projection image is computed and the
 * search window center shifts to the mass center. The procedure is repeated
 * until the specified number of iterations <code>criteria.maxCount</code> is
 * done or until the window center shifts by less than <code>criteria.epsilon</code>.
 * The algorithm is used inside "CamShift" and, unlike "CamShift", the search
 * window size or orientation do not change during the search. You can simply
 * pass the output of "calcBackProject" to this function. But better results can
 * be obtained if you pre-filter the back projection and remove the noise. For
 * example, you can do this by retrieving connected components with
 * "findContours", throwing away contours with small area ("contourArea"), and
 * rendering the remaining contours with "drawContours".</p>
 *
 * @param probImage Back projection of the object histogram. See
 * "calcBackProject" for details.
 * @param window Initial search window.
 * @param criteria Stop criteria for the iterative search algorithm.
 *
 * <p>:returns: Number of iterations CAMSHIFT took to converge.</p>
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#meanshift">org.opencv.video.Video.meanShift</a>
 */
    public static int meanShift(Mat probImage, Rect window, TermCriteria criteria)
    {
        double[] window_out = new double[4];
        int retVal = meanShift_0(probImage.nativeObj, window.x, window.y, window.width, window.height, window_out, criteria.type, criteria.maxCount, criteria.epsilon);
        if(window!=null){ window.x = (int)window_out[0]; window.y = (int)window_out[1]; window.width = (int)window_out[2]; window.height = (int)window_out[3]; }
        return retVal;
    }


    //
    // C++:  void segmentMotion(Mat mhi, Mat& segmask, vector_Rect& boundingRects, double timestamp, double segThresh)
    //

/**
 * <p>Splits a motion history image into a few parts corresponding to separate
 * independent motions (for example, left hand, right hand).</p>
 *
 * <p>The function finds all of the motion segments and marks them in
 * <code>segmask</code> with individual values (1,2,...). It also computes a
 * vector with ROIs of motion connected components. After that the motion
 * direction for every component can be calculated with "calcGlobalOrientation"
 * using the extracted mask of the particular component.</p>
 *
 * @param mhi Motion history image.
 * @param segmask Image where the found mask should be stored, single-channel,
 * 32-bit floating-point.
 * @param boundingRects Vector containing ROIs of motion connected components.
 * @param timestamp Current time in milliseconds or other units.
 * @param segThresh Segmentation threshold that is recommended to be equal to
 * the interval between motion history "steps" or greater.
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#segmentmotion">org.opencv.video.Video.segmentMotion</a>
 */
    public static void segmentMotion(Mat mhi, Mat segmask, MatOfRect boundingRects, double timestamp, double segThresh)
    {
        Mat boundingRects_mat = boundingRects;
        segmentMotion_0(mhi.nativeObj, segmask.nativeObj, boundingRects_mat.nativeObj, timestamp, segThresh);

        return;
    }


    //
    // C++:  void updateMotionHistory(Mat silhouette, Mat& mhi, double timestamp, double duration)
    //

/**
 * <p>Updates the motion history image by a moving silhouette.</p>
 *
 * <p>The function updates the motion history image as follows:</p>
 *
 * <p><em>mhi(x,y)= timestamp if silhouette(x,y) != 0; 0 if silhouette(x,y) = 0 and
 * mhi < (timestamp - duration); mhi(x,y) otherwise</em></p>
 *
 * <p>That is, MHI pixels where the motion occurs are set to the current
 * <code>timestamp</code>, while the pixels where the motion happened last time
 * a long time ago are cleared.</p>
 *
 * <p>The function, together with "calcMotionGradient" and "calcGlobalOrientation",
 * implements a motion templates technique described in [Davis97] and
 * [Bradski00].
 * See also the OpenCV sample <code>motempl.c</code> that demonstrates the use
 * of all the motion template functions.</p>
 *
 * @param silhouette Silhouette mask that has non-zero pixels where the motion
 * occurs.
 * @param mhi Motion history image that is updated by the function
 * (single-channel, 32-bit floating-point).
 * @param timestamp Current time in milliseconds or other units.
 * @param duration Maximal duration of the motion track in the same units as
 * <code>timestamp</code>.
 *
 * @see <a href="http://docs.opencv.org/modules/video/doc/motion_analysis_and_object_tracking.html#updatemotionhistory">org.opencv.video.Video.updateMotionHistory</a>
 */
    public static void updateMotionHistory(Mat silhouette, Mat mhi, double timestamp, double duration)
    {

        updateMotionHistory_0(silhouette.nativeObj, mhi.nativeObj, timestamp, duration);

        return;
    }




    //
    // native stuff
    //
    static { System.loadLibrary("opencv_java"); }

    // C++:  RotatedRect CamShift(Mat probImage, Rect& window, TermCriteria criteria)
    private static native double[] CamShift_0(long probImage_nativeObj, int window_x, int window_y, int window_width, int window_height, double[] window_out, int criteria_type, int criteria_maxCount, double criteria_epsilon);

    // C++:  double calcGlobalOrientation(Mat orientation, Mat mask, Mat mhi, double timestamp, double duration)
    private static native double calcGlobalOrientation_0(long orientation_nativeObj, long mask_nativeObj, long mhi_nativeObj, double timestamp, double duration);

    // C++:  void calcMotionGradient(Mat mhi, Mat& mask, Mat& orientation, double delta1, double delta2, int apertureSize = 3)
    private static native void calcMotionGradient_0(long mhi_nativeObj, long mask_nativeObj, long orientation_nativeObj, double delta1, double delta2, int apertureSize);
    private static native void calcMotionGradient_1(long mhi_nativeObj, long mask_nativeObj, long orientation_nativeObj, double delta1, double delta2);

    // C++:  void calcOpticalFlowFarneback(Mat prev, Mat next, Mat& flow, double pyr_scale, int levels, int winsize, int iterations, int poly_n, double poly_sigma, int flags)
    private static native void calcOpticalFlowFarneback_0(long prev_nativeObj, long next_nativeObj, long flow_nativeObj, double pyr_scale, int levels, int winsize, int iterations, int poly_n, double poly_sigma, int flags);

    // C++:  void calcOpticalFlowPyrLK(Mat prevImg, Mat nextImg, vector_Point2f prevPts, vector_Point2f& nextPts, vector_uchar& status, vector_float& err, Size winSize = Size(21,21), int maxLevel = 3, TermCriteria criteria = TermCriteria( TermCriteria::COUNT+TermCriteria::EPS, 30, 0.01), int flags = 0, double minEigThreshold = 1e-4)
    private static native void calcOpticalFlowPyrLK_0(long prevImg_nativeObj, long nextImg_nativeObj, long prevPts_mat_nativeObj, long nextPts_mat_nativeObj, long status_mat_nativeObj, long err_mat_nativeObj, double winSize_width, double winSize_height, int maxLevel, int criteria_type, int criteria_maxCount, double criteria_epsilon, int flags, double minEigThreshold);
    private static native void calcOpticalFlowPyrLK_1(long prevImg_nativeObj, long nextImg_nativeObj, long prevPts_mat_nativeObj, long nextPts_mat_nativeObj, long status_mat_nativeObj, long err_mat_nativeObj, double winSize_width, double winSize_height, int maxLevel);
    private static native void calcOpticalFlowPyrLK_2(long prevImg_nativeObj, long nextImg_nativeObj, long prevPts_mat_nativeObj, long nextPts_mat_nativeObj, long status_mat_nativeObj, long err_mat_nativeObj);

    // C++:  Mat estimateRigidTransform(Mat src, Mat dst, bool fullAffine)
    private static native long estimateRigidTransform_0(long src_nativeObj, long dst_nativeObj, boolean fullAffine);

    // C++:  int meanShift(Mat probImage, Rect& window, TermCriteria criteria)
    private static native int meanShift_0(long probImage_nativeObj, int window_x, int window_y, int window_width, int window_height, double[] window_out, int criteria_type, int criteria_maxCount, double criteria_epsilon);

    // C++:  void segmentMotion(Mat mhi, Mat& segmask, vector_Rect& boundingRects, double timestamp, double segThresh)
    private static native void segmentMotion_0(long mhi_nativeObj, long segmask_nativeObj, long boundingRects_mat_nativeObj, double timestamp, double segThresh);

    // C++:  void updateMotionHistory(Mat silhouette, Mat& mhi, double timestamp, double duration)
    private static native void updateMotionHistory_0(long silhouette_nativeObj, long mhi_nativeObj, double timestamp, double duration);

}
